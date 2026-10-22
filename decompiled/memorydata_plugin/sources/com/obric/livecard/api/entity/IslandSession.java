package com.obric.livecard.api.entity;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.livecard.api.ILiveCard;
import com.obric.livecard.api.IslandCardCallback;
import com.obric.livecard.api.LiveCardType;
import com.obric.livecard.api.island.IslandApi;
import com.obric.memorydata.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\bI\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\b\u0018\u0000 z2\u00020\u0001:\u0001zB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0012\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007BË\u0001\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010!J\u000b\u0010O\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010Q\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0002\u0010(J\u000b\u0010R\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\t\u0010S\u001a\u00020\u0012HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u001dHÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u001fHÆ\u0003J\u0010\u0010V\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010#J\t\u0010W\u001a\u00020\u0006HÂ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0010\u0010]\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010#J\t\u0010^\u001a\u00020\u0012HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0015HÆ\u0003JÔ\u0001\u0010`\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00122\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001¢\u0006\u0002\u0010aJ\b\u0010b\u001a\u00020\u0006H\u0016J\u0013\u0010c\u001a\u00020\u00182\b\u0010d\u001a\u0004\u0018\u00010\u001dH\u0096\u0002J\u0013\u0010e\u001a\u0004\u0018\u00010\u0012H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010fJ\b\u0010g\u001a\u00020\u0006H\u0016J\u000e\u0010h\u001a\u00020i2\u0006\u0010\u0002\u001a\u00020\u0003J\u0006\u0010j\u001a\u00020iJ \u0010k\u001a\u00020i2\u0006\u0010l\u001a\u00020\t2\u0006\u0010m\u001a\u00020n2\b\u0010o\u001a\u0004\u0018\u00010\u001dJ \u0010p\u001a\u00020i2\u0006\u0010l\u001a\u00020\t2\u0006\u0010m\u001a\u00020n2\b\u0010o\u001a\u0004\u0018\u00010\u001aJ\"\u0010q\u001a\u00020i2\u0006\u0010l\u001a\u00020\t2\u0006\u0010m\u001a\u00020n2\b\u0010o\u001a\u0004\u0018\u00010nH\u0002J\u000e\u0010r\u001a\u00020i2\u0006\u0010s\u001a\u00020\u0012J\b\u0010t\u001a\u00020nH\u0016J\u000e\u0010u\u001a\u00020i2\u0006\u0010l\u001a\u00020\tJ\u0019\u0010v\u001a\u00020i2\u0006\u0010l\u001a\u00020\tH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010wJ\u0006\u0010x\u001a\u00020iJ\u0018\u0010y\u001a\u00020i2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0006H\u0016R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010-\"\u0004\b/\u00100R\u0013\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b1\u0010-R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u0010\u001b\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0015\u0010 \u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010$\u001a\u0004\b>\u0010#R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010-\"\u0004\b@\u00100R\u001c\u0010\f\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010-\"\u0004\bB\u00100R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001a\u0010\u0013\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u00107\"\u0004\bL\u00109R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006{"}, d2 = {"Lcom/obric/livecard/api/entity/IslandSession;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "version", "", "(ILandroid/os/Parcel;)V", "collapseWidget", "Lcom/obric/livecard/api/entity/IslandWidget;", "expandWidget", "nodeWidget", "notificationWidget", MemorySourceLinkType.INTENT, "Landroid/app/PendingIntent;", "callback", "Lcom/obric/livecard/api/IslandCardCallback;", "autoDismissDuration", "", "taskId", "type", "Lcom/obric/livecard/api/LiveCardType;", "currWidget", "canFrontShow", "", "ext", "Lcom/google/gson/JsonObject;", "flags", "sessionContext", "", "sceneEntity", "Lcom/obric/livecard/api/entity/ISceneEntity;", "islandAutoDismissDuration", "(Lcom/obric/livecard/api/entity/IslandWidget;Lcom/obric/livecard/api/entity/IslandWidget;Lcom/obric/livecard/api/entity/IslandWidget;Lcom/obric/livecard/api/entity/IslandWidget;Landroid/app/PendingIntent;Lcom/obric/livecard/api/IslandCardCallback;Ljava/lang/Long;JLcom/obric/livecard/api/LiveCardType;Lcom/obric/livecard/api/entity/IslandWidget;Ljava/lang/Boolean;Lcom/google/gson/JsonObject;JLjava/lang/Object;Lcom/obric/livecard/api/entity/ISceneEntity;Ljava/lang/Long;I)V", "getAutoDismissDuration", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCallback", "()Lcom/obric/livecard/api/IslandCardCallback;", "getCanFrontShow", "()Ljava/lang/Boolean;", "setCanFrontShow", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getCollapseWidget", "()Lcom/obric/livecard/api/entity/IslandWidget;", "getCurrWidget", "setCurrWidget", "(Lcom/obric/livecard/api/entity/IslandWidget;)V", "getExpandWidget", "getExt", "()Lcom/google/gson/JsonObject;", "setExt", "(Lcom/google/gson/JsonObject;)V", "getFlags", "()J", "setFlags", "(J)V", "getIntent", "()Landroid/app/PendingIntent;", "setIntent", "(Landroid/app/PendingIntent;)V", "getIslandAutoDismissDuration", "getNodeWidget", "setNodeWidget", "getNotificationWidget", "setNotificationWidget", "getSceneEntity", "()Lcom/obric/livecard/api/entity/ISceneEntity;", "setSceneEntity", "(Lcom/obric/livecard/api/entity/ISceneEntity;)V", "getSessionContext", "()Ljava/lang/Object;", "setSessionContext", "(Ljava/lang/Object;)V", "getTaskId", "setTaskId", "getType", "()Lcom/obric/livecard/api/LiveCardType;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lcom/obric/livecard/api/entity/IslandWidget;Lcom/obric/livecard/api/entity/IslandWidget;Lcom/obric/livecard/api/entity/IslandWidget;Lcom/obric/livecard/api/entity/IslandWidget;Landroid/app/PendingIntent;Lcom/obric/livecard/api/IslandCardCallback;Ljava/lang/Long;JLcom/obric/livecard/api/LiveCardType;Lcom/obric/livecard/api/entity/IslandWidget;Ljava/lang/Boolean;Lcom/google/gson/JsonObject;JLjava/lang/Object;Lcom/obric/livecard/api/entity/ISceneEntity;Ljava/lang/Long;I)Lcom/obric/livecard/api/entity/IslandSession;", "describeContents", "equals", "other", "getPriority", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hashCode", "readFromParcel", "", "refreshScene", "sendAnyEvent", "targetWidget", "eventId", "", "data", "sendEvent", "sendEventInner", "setPriority", "priority", "toString", BuildConfig.CHANNEL, "updateAnimation", "(Lcom/obric/livecard/api/entity/IslandWidget;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateFlags", "writeToParcel", "CREATOR", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class IslandSession implements Parcelable {
    public static final CREATOR CREATOR = null;
    public static final int MAGIC_CODE = 429261353;
    public static final int VERSION_CODE = 4;
    private final Long autoDismissDuration;
    private final IslandCardCallback callback;
    private Boolean canFrontShow;
    private final IslandWidget collapseWidget;
    private IslandWidget currWidget;
    private final IslandWidget expandWidget;
    private JsonObject ext;
    private long flags;
    private PendingIntent intent;
    private final Long islandAutoDismissDuration;
    private IslandWidget nodeWidget;
    private IslandWidget notificationWidget;
    private ISceneEntity sceneEntity;
    private Object sessionContext;
    private long taskId;
    private final LiveCardType type;
    private final int version;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u001d\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\rJ\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/livecard/api/entity/IslandSession$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/livecard/api/entity/IslandSession;", "()V", "MAGIC_CODE", "", "VERSION_CODE", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "(I)[Lcom/obric/livecard/api/entity/IslandSession;", "parseSceneEntity", "Lcom/obric/livecard/api/entity/ISceneEntity;", "json", "", "readVersion", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<IslandSession> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r1) {
            this();
        }

        public static final /* synthetic */ ISceneEntity access$parseSceneEntity(CREATOR r0, String r1) {
            return r0.parseSceneEntity(r1);
        }

        public static final /* synthetic */ int access$readVersion(CREATOR r0, Parcel r1) {
            return r0.readVersion(r1);
        }

        private final ISceneEntity parseSceneEntity(String r1) {
            return SceneEntityParser.INSTANCE.parse(r1);
        }

        private final int readVersion(Parcel r4) {
            int r3 = r4.dataPosition();
            int r0 = 0;
        L8:
            r4.setDataPosition(r3);
        L9:
            return r0;
        L4:
            if (r4.readInt() != 429261353) goto L6;
            r3 = r4.readInt();     // Catch: Exception -> L8
            r0 = r3;
        L10:
            goto L9
        L6:
            r4.setDataPosition(r3);     // Catch: Exception -> L8
            goto L10
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IslandSession createFromParcel(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new IslandSession(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ IslandSession createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IslandSession[] newArray(int r1) {
            return new IslandSession[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ IslandSession[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public IslandSession() {
        this(null, null, null, null, null, null, null, 0, null, null, null, null, 0, null, null, null, 0, 131071, null);
    }

    private IslandSession(int r24, Parcel r25) {
        IslandWidget r1 = (IslandWidget) ZeusTransformUtils.preCheckCast(r25.readParcelable(IslandWidget.class.getClassLoader()), IslandWidget.class, "com.obric.memorydata.plugin");
        IslandWidget r2 = (IslandWidget) ZeusTransformUtils.preCheckCast(r25.readParcelable(IslandWidget.class.getClassLoader()), IslandWidget.class, "com.obric.memorydata.plugin");
        PendingIntent r5 = (PendingIntent) ZeusTransformUtils.preCheckCast(r25.readParcelable(PendingIntent.class.getClassLoader()), PendingIntent.class, "com.obric.memorydata.plugin");
        Object r4 = r25.readValue(Long.TYPE.getClassLoader());
        if (ZeusTransformUtils.instanceOf(r4, Long.class) == false) goto L5;
        Long r8 = (Long) ZeusTransformUtils.preCheckCast(r4, Long.class, "com.obric.memorydata.plugin");
    L6:
        long r9 = r25.readLong();
        LiveCardType.Companion r6 = LiveCardType.Companion;
        String r7 = r25.readString();
        if (r7 != null) goto L9;
        r7 = "";
    L9:
        LiveCardType r13 = r6.fromString(r7);
        boolean r10 = r25.readBoolean();
        String r11 = r25.readString();
        if (r11 == null) goto L12;
        JsonObject r15 = (JsonObject) ZeusTransformUtils.preCheckCast(new Gson().fromJson(r11, JsonObject.class), JsonObject.class, "com.obric.memorydata.plugin");
    L14:
        if (r24 < 1) goto L16;
        long r12 = r25.readLong();
    L17:
        long r17 = r12;
        if (r24 < 2) goto L20;
        IslandWidget r19 = IslandSessionEntityKt.readWidgetFromParcel(r25);
    L21:
        if (r24 < 2) goto L23;
        ISceneEntity r20 = CREATOR.access$parseSceneEntity(CREATOR, r25.readString());
    L25:
        if (r24 < 3) goto L27;
        IslandWidget r21 = IslandSessionEntityKt.readWidgetFromParcel(r25);
    L29:
        if (r24 < 4) goto L33;
        Object r0 = r25.readValue(Long.TYPE.getClassLoader());
        if (ZeusTransformUtils.instanceOf(r0, Long.class) == false) goto L33;
        Long r22 = (Long) ZeusTransformUtils.preCheckCast(r0, Long.class, "com.obric.memorydata.plugin");
    L34:
        this(r1, r2, r19, r21, r5, null, r8, r9, r13, null, Boolean.valueOf(r10), r15, r17, null, r20, r22, r24);
        return;
    L33:
        r22 = null;
        goto L34
    L27:
        r21 = null;
        goto L29
    L23:
        r20 = null;
        goto L25
    L20:
        r19 = null;
        goto L21
    L16:
        r12 = 0;
        goto L17
    L12:
        r15 = null;
        goto L14
    L5:
        r8 = null;
        goto L6
    }

    public IslandSession(Parcel r2) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        this(CREATOR.access$readVersion(CREATOR, r2), r2);
    }

    public IslandSession(IslandWidget r6, IslandWidget r7, IslandWidget r8, IslandWidget r9, PendingIntent r10, IslandCardCallback r11, Long r12, long r13, LiveCardType r15, IslandWidget r16, Boolean r17, JsonObject r18, long r19, Object r21, ISceneEntity r22, Long r23, int r24) {
        IslandCardCallback r1 = (IslandCardCallback) ZeusTransformUtils.wrapperContextForParams(r11, IslandCardCallback.class, "com.obric.memorydata.plugin");
        ISceneEntity r2 = (ISceneEntity) ZeusTransformUtils.wrapperContextForParams(r22, ISceneEntity.class, "com.obric.memorydata.plugin");
        this.collapseWidget = r6;
        this.expandWidget = r7;
        this.nodeWidget = r8;
        this.notificationWidget = r9;
        this.intent = r10;
        this.callback = r1;
        this.autoDismissDuration = r12;
        this.taskId = r13;
        this.type = r15;
        this.currWidget = r16;
        this.canFrontShow = r17;
        this.ext = r18;
        this.flags = r19;
        this.sessionContext = r21;
        this.sceneEntity = r2;
        this.islandAutoDismissDuration = r23;
        this.version = r24;
    }

    public /* synthetic */ IslandSession(IslandWidget r21, IslandWidget r22, IslandWidget r23, IslandWidget r24, PendingIntent r25, IslandCardCallback r26, Long r27, long r28, LiveCardType r30, IslandWidget r31, Boolean r32, JsonObject r33, long r34, Object r36, ISceneEntity r37, Long r38, int r39, int r40, DefaultConstructorMarker r41) {
        IslandCardCallback r1 = (IslandCardCallback) ZeusTransformUtils.wrapperContextForParams(r26, IslandCardCallback.class, "com.obric.memorydata.plugin");
        ISceneEntity r2 = (ISceneEntity) ZeusTransformUtils.wrapperContextForParams(r37, ISceneEntity.class, "com.obric.memorydata.plugin");
        if ((r40 & 1) == 0) goto L5;
        IslandWidget r3 = null;
    L7:
        if ((r40 & 2) == 0) goto L9;
        IslandWidget r5 = null;
    L11:
        if ((r40 & 4) == 0) goto L13;
        IslandWidget r6 = null;
    L15:
        if ((r40 & 8) == 0) goto L17;
        IslandWidget r7 = null;
    L19:
        if ((r40 & 16) == 0) goto L21;
        PendingIntent r8 = null;
    L23:
        if ((r40 & 32) == 0) goto L26;
        r1 = null;
    L26:
        if ((r40 & 64) == 0) goto L28;
        Long r9 = null;
    L30:
        if ((r40 & 128) == 0) goto L32;
        long r13 = 0;
    L34:
        if ((r40 & 256) == 0) goto L36;
        LiveCardType r10 = null;
    L38:
        if ((r40 & 512) == 0) goto L40;
        IslandWidget r15 = null;
    L42:
        if ((r40 & 1024) == 0) goto L44;
        Boolean r4 = false;
    L46:
        if ((r40 & 2048) == 0) goto L48;
        JsonObject r11 = null;
    L50:
        if ((r40 & 4096) == 0) goto L52;
        long r16 = 0;
    L54:
        if ((r40 & 8192) == 0) goto L56;
        Object r12 = null;
    L58:
        if ((r40 & 16384) == 0) goto L60;
        ISceneEntity r14 = null;
    L62:
        if ((r40 & 32768) == 0) goto L64;
        Long r18 = null;
    L66:
        if ((r40 & 65536) == 0) goto L68;
        int r0 = 4;
    L69:
        this(r3, r5, r6, r7, r8, r1, r9, r13, r10, r15, r4, r11, r16, r12, r14, r18, r0);
        return;
    L68:
        r0 = r39;
        goto L69
    L64:
        r18 = r38;
        goto L66
    L60:
        r14 = r2;
        goto L62
    L56:
        r12 = r36;
        goto L58
    L52:
        r16 = r34;
        goto L54
    L48:
        r11 = r33;
        goto L50
    L44:
        r4 = r32;
        goto L46
    L40:
        r15 = r31;
        goto L42
    L36:
        r10 = r30;
        goto L38
    L32:
        r13 = r28;
        goto L34
    L28:
        r9 = r27;
        goto L30
    L21:
        r8 = r25;
        goto L23
    L17:
        r7 = r24;
        goto L19
    L13:
        r6 = r23;
        goto L15
    L9:
        r5 = r22;
        goto L11
    L5:
        r3 = r21;
        goto L7
    }

    private final int component17() {
        return this.version;
    }

    public static /* synthetic */ IslandSession copy$default(IslandSession r17, IslandWidget r18, IslandWidget r19, IslandWidget r20, IslandWidget r21, PendingIntent r22, IslandCardCallback r23, Long r24, long r25, LiveCardType r27, IslandWidget r28, Boolean r29, JsonObject r30, long r31, Object r33, ISceneEntity r34, Long r35, int r36, int r37, Object r38) {
        IslandCardCallback r2 = (IslandCardCallback) ZeusTransformUtils.wrapperContextForParams(r23, IslandCardCallback.class, "com.obric.memorydata.plugin");
        ISceneEntity r3 = (ISceneEntity) ZeusTransformUtils.wrapperContextForParams(r34, ISceneEntity.class, "com.obric.memorydata.plugin");
        if ((r37 & 1) == 0) goto L5;
        IslandWidget r4 = r17.collapseWidget;
    L7:
        if ((r37 & 2) == 0) goto L9;
        IslandWidget r5 = r17.expandWidget;
    L11:
        if ((r37 & 4) == 0) goto L13;
        IslandWidget r6 = r17.nodeWidget;
    L15:
        if ((r37 & 8) == 0) goto L17;
        IslandWidget r7 = r17.notificationWidget;
    L19:
        if ((r37 & 16) == 0) goto L21;
        PendingIntent r8 = r17.intent;
    L23:
        if ((r37 & 32) == 0) goto L26;
        r2 = r17.callback;
    L26:
        if ((r37 & 64) == 0) goto L28;
        Long r9 = r17.autoDismissDuration;
    L30:
        if ((r37 & 128) == 0) goto L32;
        long r10 = r17.taskId;
    L34:
        if ((r37 & 256) == 0) goto L36;
        LiveCardType r12 = r17.type;
    L38:
        if ((r37 & 512) == 0) goto L40;
        IslandWidget r13 = r17.currWidget;
    L42:
        if ((r37 & 1024) == 0) goto L44;
        Boolean r14 = r17.canFrontShow;
    L46:
        if ((r37 & 2048) == 0) goto L48;
        JsonObject r15 = r17.ext;
    L49:
        Boolean r210 = r14;
        JsonObject r32 = r15;
        if ((r37 & 4096) == 0) goto L52;
        long r16 = r17.flags;
    L54:
        if ((r37 & 8192) == 0) goto L56;
        Object r11 = r17.sessionContext;
    L57:
        Object r39 = r11;
        if ((r37 & 16384) == 0) goto L60;
        ISceneEntity r26 = r17.sceneEntity;
    L61:
        ISceneEntity r310 = r26;
        if ((r37 & 32768) == 0) goto L64;
        Long r40 = r17.islandAutoDismissDuration;
    L66:
        if ((r37 & 65536) == 0) goto L68;
        int r1 = r17.version;
    L70:
        return r17.copy(r4, r5, r6, r7, r8, r2, r9, r10, r12, r13, r210, r32, r16, r39, r310, r40, r1);
    L68:
        r1 = r36;
        goto L70
    L64:
        r40 = r35;
        goto L66
    L60:
        r26 = r3;
        goto L61
    L56:
        r11 = r33;
        goto L57
    L52:
        r16 = r31;
        goto L54
    L48:
        r15 = r30;
        goto L49
    L44:
        r14 = r29;
        goto L46
    L40:
        r13 = r28;
        goto L42
    L36:
        r12 = r27;
        goto L38
    L32:
        r10 = r25;
        goto L34
    L28:
        r9 = r24;
        goto L30
    L21:
        r8 = r22;
        goto L23
    L17:
        r7 = r21;
        goto L19
    L13:
        r6 = r20;
        goto L15
    L9:
        r5 = r19;
        goto L11
    L5:
        r4 = r18;
        goto L7
    }

    private final void sendEventInner(IslandWidget r2, String r3, String r4) {
        IslandApi r0 = ILiveCard.Companion.getInst().getIslandService();
        if (r0 == null) goto L6;
        r0.sendEvent(this, r2, r3, r4);
        return;
    }

    public final IslandWidget component1() {
        return this.collapseWidget;
    }

    public final IslandWidget component10() {
        return this.currWidget;
    }

    public final Boolean component11() {
        return this.canFrontShow;
    }

    public final JsonObject component12() {
        return this.ext;
    }

    public final long component13() {
        return this.flags;
    }

    public final Object component14() {
        return this.sessionContext;
    }

    public final ISceneEntity component15() {
        return this.sceneEntity;
    }

    public final Long component16() {
        return this.islandAutoDismissDuration;
    }

    public final IslandWidget component2() {
        return this.expandWidget;
    }

    public final IslandWidget component3() {
        return this.nodeWidget;
    }

    public final IslandWidget component4() {
        return this.notificationWidget;
    }

    public final PendingIntent component5() {
        return this.intent;
    }

    public final IslandCardCallback component6() {
        return this.callback;
    }

    public final Long component7() {
        return this.autoDismissDuration;
    }

    public final long component8() {
        return this.taskId;
    }

    public final LiveCardType component9() {
        return this.type;
    }

    public final IslandSession copy(IslandWidget r22, IslandWidget r23, IslandWidget r24, IslandWidget r25, PendingIntent r26, IslandCardCallback r27, Long r28, long r29, LiveCardType r31, IslandWidget r32, Boolean r33, JsonObject r34, long r35, Object r37, ISceneEntity r38, Long r39, int r40) {
        return new IslandSession(r22, r23, r24, r25, r26, (IslandCardCallback) ZeusTransformUtils.wrapperContextForParams(r27, IslandCardCallback.class, "com.obric.memorydata.plugin"), r28, r29, r31, r32, r33, r34, r35, r37, (ISceneEntity) ZeusTransformUtils.wrapperContextForParams(r38, ISceneEntity.class, "com.obric.memorydata.plugin"), r39, r40);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L5;
        return true;
    L5:
        Class<?> r2 = getClass();
        if (r9 == null) goto L8;
        Class<?> r3 = r9.getClass();
    L10:
        if (Intrinsics.areEqual(r2, r3) == true) goto L13;
        return false;
    L13:
        if (this.taskId != 0) goto L15;
        return false;
    L15:
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type com.obric.livecard.api.entity.IslandSession");
        IslandSession r4 = (IslandSession) ZeusTransformUtils.preCheckCast(r9, IslandSession.class, "com.obric.memorydata.plugin");
        if (this.taskId != ((IslandSession) ZeusTransformUtils.preCheckCast(r9, IslandSession.class, "com.obric.memorydata.plugin")).taskId) goto L19;
        return true;
    L19:
        return false;
    L8:
        r3 = null;
        goto L10
    }

    public final Long getAutoDismissDuration() {
        return this.autoDismissDuration;
    }

    public final IslandCardCallback getCallback() {
        return this.callback;
    }

    public final Boolean getCanFrontShow() {
        return this.canFrontShow;
    }

    public final IslandWidget getCollapseWidget() {
        return this.collapseWidget;
    }

    public final IslandWidget getCurrWidget() {
        return this.currWidget;
    }

    public final IslandWidget getExpandWidget() {
        return this.expandWidget;
    }

    public final JsonObject getExt() {
        return this.ext;
    }

    public final long getFlags() {
        return this.flags;
    }

    public final PendingIntent getIntent() {
        return this.intent;
    }

    public final Long getIslandAutoDismissDuration() {
        return this.islandAutoDismissDuration;
    }

    public final IslandWidget getNodeWidget() {
        return this.nodeWidget;
    }

    public final IslandWidget getNotificationWidget() {
        return this.notificationWidget;
    }

    public final Object getPriority(Continuation<? super Long> r3) {
        Continuation<? super Long> r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        IslandApi r0 = ILiveCard.Companion.getInst().getIslandService();
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getPriority(this, r4);
    }

    public final ISceneEntity getSceneEntity() {
        return this.sceneEntity;
    }

    public final Object getSessionContext() {
        return this.sessionContext;
    }

    public final long getTaskId() {
        return this.taskId;
    }

    public final LiveCardType getType() {
        return this.type;
    }

    public int hashCode() {
        return Long.hashCode(this.taskId);
    }

    public final void readFromParcel(Parcel r7) {
        Intrinsics.checkNotNullParameter(r7, "parcel");
        CREATOR r0 = CREATOR;
        int r1 = CREATOR.access$readVersion(r0, r7);
        r7.readParcelable(IslandWidget.class.getClassLoader());
        r7.readParcelable(IslandWidget.class.getClassLoader());
        r7.readParcelable(PendingIntent.class.getClassLoader());
        Object r2 = r7.readValue(Long.TYPE.getClassLoader());
        if (ZeusTransformUtils.instanceOf(r2, Long.class) == false) goto L5;
        Long r3 = (Long) ZeusTransformUtils.preCheckCast(r2, Long.class, "com.obric.memorydata.plugin");
    L5:
        this.taskId = r7.readLong();
        r7.readString();
        r7.readBoolean();
        String r4 = r7.readString();
        if (r4 == null) goto L8;
        JsonObject r5 = (JsonObject) ZeusTransformUtils.preCheckCast(new Gson().fromJson(r4, JsonObject.class), JsonObject.class, "com.obric.memorydata.plugin");
    L9:
        this.ext = r5;
        if (r1 < 1) goto L13;
        r7.readLong();
    L13:
        if (r1 < 2) goto L16;
        r7.readParcelable(IslandWidget.class.getClassLoader());
        this.sceneEntity = CREATOR.access$parseSceneEntity(r0, r7.readString());
    L16:
        if (r1 < 3) goto L19;
        r7.readParcelable(IslandWidget.class.getClassLoader());
    L19:
        if (r1 < 4) goto L24;
        Object r6 = r7.readValue(Long.TYPE.getClassLoader());
        if (ZeusTransformUtils.instanceOf(r6, Long.class) == false) goto L25;
        Long r8 = (Long) ZeusTransformUtils.preCheckCast(r6, Long.class, "com.obric.memorydata.plugin");
        return;
    L25:
        return;
    L24:
        return;
    L8:
        r5 = null;
        goto L9
    }

    public final void refreshScene() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        IslandApi r1 = ILiveCard.Companion.getInst().getIslandService();     // Catch: Throwable -> L8
        if (r1 == null) goto L5;
        r1.refreshScene(this);     // Catch: Throwable -> L8
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L8
    L6:
        Result.m1421constructorimpl(r2);     // Catch: Throwable -> L8
        return;
    L5:
        r2 = null;
    L8:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    }

    public final void sendAnyEvent(IslandWidget r4, String r5, Object r6) {
        Intrinsics.checkNotNullParameter(r4, "targetWidget");
        Intrinsics.checkNotNullParameter(r5, "eventId");
        String r2 = null;
        if (ZeusTransformUtils.instanceOf(r6, JsonObject.class) == false) goto L5;
        JsonObject r0 = (JsonObject) ZeusTransformUtils.preCheckCast(r6, JsonObject.class, "com.obric.memorydata.plugin");
    L6:
        if (r0 == null) goto L10;
        sendEvent(r4, r5, r0);
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r6, String.class) == false) goto L12;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin");
    L13:
        if (r1 == null) goto L16;
        sendEventInner(r4, r5, r1);
        return;
    L16:
        if (r6 == null) goto L18;
        r2 = new Gson().toJson(r6);
    L18:
        sendEventInner(r4, r5, r2);
        return;
    L12:
        r1 = null;
        goto L13
    L5:
        r0 = null;
        goto L6
    }

    public final void sendEvent(IslandWidget r2, String r3, JsonObject r4) {
        Intrinsics.checkNotNullParameter(r2, "targetWidget");
        Intrinsics.checkNotNullParameter(r3, "eventId");
        if (r4 == null) goto L5;
        String r5 = r4.toString();
    L6:
        sendEventInner(r2, r3, r5);
        return;
    L5:
        r5 = null;
        goto L6
    }

    public final void setCanFrontShow(Boolean r1) {
        this.canFrontShow = r1;
    }

    public final void setCurrWidget(IslandWidget r1) {
        this.currWidget = r1;
    }

    public final void setExt(JsonObject r1) {
        this.ext = r1;
    }

    public final void setFlags(long r1) {
        this.flags = r1;
    }

    public final void setIntent(PendingIntent r1) {
        this.intent = r1;
    }

    public final void setNodeWidget(IslandWidget r1) {
        this.nodeWidget = r1;
    }

    public final void setNotificationWidget(IslandWidget r1) {
        this.notificationWidget = r1;
    }

    public final void setPriority(long r2) {
        IslandApi r0 = ILiveCard.Companion.getInst().getIslandService();
        if (r0 == null) goto L6;
        r0.setPriority(this, r2);
        return;
    }

    public final void setSceneEntity(ISceneEntity r3) {
        this.sceneEntity = (ISceneEntity) ZeusTransformUtils.wrapperContextForParams(r3, ISceneEntity.class, "com.obric.memorydata.plugin");
    }

    public final void setSessionContext(Object r1) {
        this.sessionContext = r1;
    }

    public final void setTaskId(long r1) {
        this.taskId = r1;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("IslandSession(collapseWidget=").append(this.collapseWidget).append(", expandWidget=").append(this.expandWidget).append(", nodeWidget=").append(this.nodeWidget).append(", notificationWidget=").append(this.notificationWidget).append(", intent=").append(this.intent).append(", autoDismissDuration=").append(this.autoDismissDuration).append(", islandAutoDismissDuration=").append(this.islandAutoDismissDuration).append(", taskId=").append(this.taskId).append(", type=").append(this.type).append(", currWidget=").append(this.currWidget).append(", canFontShow=").append(this.canFrontShow).append(", flags=");
        r0.append(this.flags).append(", sceneEntity=").append(this.sceneEntity).append(')');
        return r0.toString();
    }

    public final void update(IslandWidget r2) {
        Intrinsics.checkNotNullParameter(r2, "targetWidget");
        IslandApi r0 = ILiveCard.Companion.getInst().getIslandService();
        if (r0 == null) goto L6;
        r0.updateWidget(this, r2);
        return;
    }

    public final Object updateAnimation(IslandWidget r3, Continuation<? super Unit> r4) {
        Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        IslandApi r0 = ILiveCard.Companion.getInst().getIslandService();
        if (r0 == null) goto L10;
        Object r2 = r0.updateAnimation(this, r3, r5);
        if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        return r2;
    L8:
        return Unit.INSTANCE;
    L10:
        return Unit.INSTANCE;
    }

    public final void updateFlags() {
        IslandApi r0 = ILiveCard.Companion.getInst().getIslandService();
        if (r0 == null) goto L6;
        r0.updateSessionFlags(this);
        return;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r9, int r10) {
        Intrinsics.checkNotNullParameter(r9, "parcel");
        boolean r0 = false;
        if (1 != r10) goto L5;
        int r2 = this.version;
    L10:
        if (r2 <= 0) goto L12;
        r9.writeInt(MAGIC_CODE);
        r9.writeInt(4);
    L12:
        r9.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.collapseWidget, Parcelable.class, "com.obric.memorydata.plugin"), r10);
        r9.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.expandWidget, Parcelable.class, "com.obric.memorydata.plugin"), r10);
        r9.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.intent, Parcelable.class, "com.obric.memorydata.plugin"), r10);
        r9.writeValue(this.autoDismissDuration);
        r9.writeLong(this.taskId);
        LiveCardType r4 = this.type;
        String r5 = null;
        if (r4 == null) goto L15;
        String r6 = r4.name();
    L16:
        r9.writeString(r6);
        Boolean r7 = this.canFrontShow;
        if (r7 == null) goto L19;
        r0 = r7.booleanValue();
    L19:
        r9.writeBoolean(r0);
        JsonObject r1 = this.ext;
        if (r1 == null) goto L22;
        String r3 = new Gson().toJson((JsonElement) ZeusTransformUtils.preCheckCast(r1, JsonElement.class, "com.obric.memorydata.plugin"));
    L23:
        r9.writeString(r3);
        if (r2 < 1) goto L27;
        r9.writeLong(this.flags);
    L27:
        if (r2 < 2) goto L33;
        r9.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.nodeWidget, Parcelable.class, "com.obric.memorydata.plugin"), r10);
        ISceneEntity r8 = this.sceneEntity;
        if (r8 == null) goto L31;
        r5 = SceneEntityParser.INSTANCE.getGson().toJson(r8);
    L31:
        r9.writeString(r5);
    L33:
        if (r2 < 3) goto L35;
        r9.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.notificationWidget, Parcelable.class, "com.obric.memorydata.plugin"), r10);
    L35:
        if (r2 < 4) goto L38;
        r9.writeValue(this.islandAutoDismissDuration);
        return;
    L38:
        return;
    L22:
        r3 = null;
        goto L23
    L15:
        r6 = null;
        goto L16
    L5:
        IslandApi r11 = ILiveCard.Companion.getInst().getIslandService();
        if (r11 == null) goto L8;
        r2 = r11.getIslandVersion();
        goto L10
    L8:
        r2 = 0;
        goto L10
    }
}
