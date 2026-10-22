package com.obric.livecard.api.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u0000 O2\u00020\u0001:\u0001OB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0095\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\u001e\b\u0002\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00160\u0015j\u0002`\u00170\u0014\u0012\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015j\u0004\u0018\u0001`\u0017¢\u0006\u0002\u0010\u0019J \u00108\u001a\u00020\u00162\u0006\u00109\u001a\u00020\u00062\u0010\u0010:\u001a\f\u0012\u0004\u0012\u00020\u00160\u0015j\u0002`\u0017J\t\u0010;\u001a\u00020\u0006HÆ\u0003J\t\u0010<\u001a\u00020\bHÆ\u0003J\u0010\u0010=\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u0010>\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0011\u0010?\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0003J\u0011\u0010@\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u001f\u0010B\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00160\u0015j\u0002`\u00170\u0014HÆ\u0003J\u0017\u0010C\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015j\u0004\u0018\u0001`\u0017HÆ\u0003J¢\u0001\u0010D\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u001e\b\u0002\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00160\u0015j\u0002`\u00170\u00142\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015j\u0004\u0018\u0001`\u0017HÆ\u0001¢\u0006\u0002\u0010EJ\b\u0010F\u001a\u00020GH\u0016J\u0013\u0010H\u001a\u00020\n2\b\u0010I\u001a\u0004\u0018\u00010\bHÖ\u0003J\u001c\u0010J\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015j\u0004\u0018\u0001`\u00172\u0006\u00109\u001a\u00020\u0006J\t\u0010K\u001a\u00020GHÖ\u0001J\b\u0010L\u001a\u00020\u0006H\u0016J\u0018\u0010M\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010N\u001a\u00020GH\u0016R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010#\u001a\u0004\b\t\u0010\"R(\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015j\u0004\u0018\u0001`\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R0\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00160\u0015j\u0002`\u00170\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001f\"\u0004\b-\u0010!R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107¨\u0006P"}, d2 = {"Lcom/obric/livecard/api/entity/IslandWidget;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "templateId", "", "templateData", "", "isDefault", "", "view", "Landroid/view/View;", "inAnimation", "", "Lcom/obric/livecard/api/entity/TransitionAnimation;", "outAnimation", "ext", "Lcom/google/gson/JsonObject;", "onClickCallback", "", "Lkotlin/Function0;", "", "Lcom/obric/livecard/api/entity/OnViewClickListener;", "onCardClickCallback", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Boolean;Landroid/view/View;Ljava/util/List;Ljava/util/List;Lcom/google/gson/JsonObject;Ljava/util/Map;Lkotlin/jvm/functions/Function0;)V", "getExt", "()Lcom/google/gson/JsonObject;", "setExt", "(Lcom/google/gson/JsonObject;)V", "getInAnimation", "()Ljava/util/List;", "setInAnimation", "(Ljava/util/List;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getOnCardClickCallback", "()Lkotlin/jvm/functions/Function0;", "setOnCardClickCallback", "(Lkotlin/jvm/functions/Function0;)V", "getOnClickCallback", "()Ljava/util/Map;", "setOnClickCallback", "(Ljava/util/Map;)V", "getOutAnimation", "setOutAnimation", "getTemplateData", "()Ljava/lang/Object;", "setTemplateData", "(Ljava/lang/Object;)V", "getTemplateId", "()Ljava/lang/String;", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "addOnViewClickCallback", "viewId", "onClick", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Boolean;Landroid/view/View;Ljava/util/List;Ljava/util/List;Lcom/google/gson/JsonObject;Ljava/util/Map;Lkotlin/jvm/functions/Function0;)Lcom/obric/livecard/api/entity/IslandWidget;", "describeContents", "", "equals", "other", "findOnViewClickCallbackById", "hashCode", "toString", "writeToParcel", "flags", "CREATOR", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class IslandWidget implements Parcelable {
    public static final CREATOR CREATOR = null;
    private JsonObject ext;
    private List<? extends TransitionAnimation> inAnimation;
    private final Boolean isDefault;
    private Function0<Unit> onCardClickCallback;
    private Map<String, Function0<Unit>> onClickCallback;
    private List<? extends TransitionAnimation> outAnimation;
    private Object templateData;
    private final String templateId;
    private View view;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/obric/livecard/api/entity/IslandWidget$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/livecard/api/entity/IslandWidget;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/livecard/api/entity/IslandWidget;", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<IslandWidget> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IslandWidget createFromParcel(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new IslandWidget(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ IslandWidget createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IslandWidget[] newArray(int r1) {
            return new IslandWidget[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ IslandWidget[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public IslandWidget(Parcel r15) {
        Intrinsics.checkNotNullParameter(r15, "parcel");
        String r0 = r15.readString();
        if (r0 != null) goto L5;
        String r3 = "";
    L6:
        String r1 = r15.readString();
        if (r1 != null) goto L9;
        String r4 = "";
    L10:
        Object r2 = r15.readValue(Boolean.TYPE.getClassLoader());
        if (ZeusTransformUtils.instanceOf(r2, Boolean.class) == false) goto L13;
        Boolean r5 = (Boolean) ZeusTransformUtils.preCheckCast(r2, Boolean.class, "com.obric.memorydata.plugin");
    L14:
        Void r6 = (Void) ZeusTransformUtils.preCheckCast(null, Void.class, "com.obric.memorydata.plugin");
        Object r7 = r15.readValue(Integer.TYPE.getClassLoader());
        if (ZeusTransformUtils.instanceOf(r7, Integer.class) == false) goto L17;
        Integer r8 = (Integer) ZeusTransformUtils.preCheckCast(r7, Integer.class, "com.obric.memorydata.plugin");
    L17:
        Object r9 = r15.readValue(Integer.TYPE.getClassLoader());
        if (ZeusTransformUtils.instanceOf(r9, Integer.class) == false) goto L20;
        Integer r10 = (Integer) ZeusTransformUtils.preCheckCast(r9, Integer.class, "com.obric.memorydata.plugin");
    L20:
        Unit r11 = Unit.INSTANCE;
        View r12 = (View) ZeusTransformUtils.preCheckCast(null, View.class, "com.obric.memorydata.plugin");
        String r13 = r15.readString();
        if (r13 == null) goto L33;
        List r14 = (List) ZeusTransformUtils.preCheckCast(new Gson().fromJson(r13, new IslandWidget$2$1().getType()), List.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L31;
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin");
        Collection r17 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r18 = r16.iterator();
    L26:
        if (r18.hasNext() == false) goto L30;
        TransitionAnimation r19 = TransitionAnimation.Companion.fromString((String) ZeusTransformUtils.preCheckCast(r18.next(), String.class, "com.obric.memorydata.plugin"));
        if (r19 == null) goto L26;
        r17.add(r19);
        goto L26
    L30:
        List r20 = (List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.memorydata.plugin");
    L32:
        List r21 = r20;
    L34:
        String r22 = r15.readString();
        if (r22 == null) goto L47;
        List r23 = (List) ZeusTransformUtils.preCheckCast(new Gson().fromJson(r22, new IslandWidget$3$1().getType()), List.class, "com.obric.memorydata.plugin");
        if (r23 == null) goto L45;
        Iterable r24 = (Iterable) ZeusTransformUtils.preCheckCast(r23, Iterable.class, "com.obric.memorydata.plugin");
        Collection r25 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r26 = r24.iterator();
    L40:
        if (r26.hasNext() == false) goto L44;
        TransitionAnimation r27 = TransitionAnimation.Companion.fromString((String) ZeusTransformUtils.preCheckCast(r26.next(), String.class, "com.obric.memorydata.plugin"));
        if (r27 == null) goto L40;
        r25.add(r27);
        goto L40
    L44:
        List r28 = (List) ZeusTransformUtils.preCheckCast(r25, List.class, "com.obric.memorydata.plugin");
    L46:
        List r29 = r28;
    L48:
        String r110 = r15.readString();
        if (r110 == null) goto L51;
        JsonObject r30 = (JsonObject) ZeusTransformUtils.preCheckCast(new Gson().fromJson(r110, JsonObject.class), JsonObject.class, "com.obric.memorydata.plugin");
    L52:
        this(r3, r4, r5, r12, r21, r29, r30, null, null, 384, null);
        return;
    L51:
        r30 = null;
        goto L52
    L45:
        r28 = null;
        goto L46
    L47:
        r29 = null;
        goto L48
    L31:
        r20 = null;
        goto L32
    L33:
        r21 = null;
        goto L34
    L13:
        r5 = null;
        goto L14
    L9:
        r4 = r1;
        goto L10
    L5:
        r3 = r0;
        goto L6
    }

    public IslandWidget(String r3, Object r4, Boolean r5, View r6, List<? extends TransitionAnimation> r7, List<? extends TransitionAnimation> r8, JsonObject r9, Map<String, Function0<Unit>> r10, Function0<Unit> r11) {
        List<? extends TransitionAnimation> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        List<? extends TransitionAnimation> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Map<String, Function0<Unit>> r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.memorydata.plugin");
        Function0<Unit> r15 = (Function0) ZeusTransformUtils.wrapperContextForParams(r11, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "templateId");
        Intrinsics.checkNotNullParameter(r4, "templateData");
        Intrinsics.checkNotNullParameter(r14, "onClickCallback");
        this.templateId = r3;
        this.templateData = r4;
        this.isDefault = r5;
        this.view = r6;
        this.inAnimation = r12;
        this.outAnimation = r13;
        this.ext = r9;
        this.onClickCallback = r14;
        this.onCardClickCallback = r15;
    }

    public /* synthetic */ IslandWidget(String r18, Object r19, Boolean r20, View r21, List r22, List r23, JsonObject r24, Map r25, Function0 r26, int r27, DefaultConstructorMarker r28) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.memorydata.plugin");
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r23, List.class, "com.obric.memorydata.plugin");
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r25, Map.class, "com.obric.memorydata.plugin");
        Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r26, Function0.class, "com.obric.memorydata.plugin");
        if ((r27 & 4) == 0) goto L5;
        Boolean r10 = false;
    L7:
        if ((r27 & 8) == 0) goto L9;
        View r11 = null;
    L11:
        if ((r27 & 16) == 0) goto L13;
        List r12 = null;
    L15:
        if ((r27 & 32) == 0) goto L17;
        List r13 = null;
    L19:
        if ((r27 & 64) == 0) goto L21;
        JsonObject r14 = null;
    L23:
        if ((r27 & 128) == 0) goto L25;
        r4 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
    L25:
        Map r15 = r4;
        if ((r27 & 256) == 0) goto L28;
        Function0 r16 = null;
    L29:
        this(r18, r19, r10, r11, r12, r13, r14, r15, r16);
        return;
    L28:
        r16 = r5;
        goto L29
    L21:
        r14 = r24;
        goto L23
    L17:
        r13 = r3;
        goto L19
    L13:
        r12 = r1;
        goto L15
    L9:
        r11 = r21;
        goto L11
    L5:
        r10 = r20;
        goto L7
    }

    public static /* synthetic */ IslandWidget copy$default(IslandWidget r12, String r13, Object r14, Boolean r15, View r16, List r17, List r18, JsonObject r19, Map r20, Function0 r21, int r22, Object r23) {
        List<? extends TransitionAnimation> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.memorydata.plugin");
        List<? extends TransitionAnimation> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin");
        Map<String, Function0<Unit>> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r20, Map.class, "com.obric.memorydata.plugin");
        Function0<Unit> r3 = (Function0) ZeusTransformUtils.wrapperContextForParams(r21, Function0.class, "com.obric.memorydata.plugin");
        if ((r22 & 1) == 0) goto L5;
        String r6 = r12.templateId;
    L7:
        if ((r22 & 2) == 0) goto L9;
        Object r7 = r12.templateData;
    L11:
        if ((r22 & 4) == 0) goto L13;
        Boolean r8 = r12.isDefault;
    L15:
        if ((r22 & 8) == 0) goto L17;
        View r9 = r12.view;
    L19:
        if ((r22 & 16) == 0) goto L22;
        r2 = r12.inAnimation;
    L22:
        if ((r22 & 32) == 0) goto L25;
        r4 = r12.outAnimation;
    L25:
        if ((r22 & 64) == 0) goto L27;
        JsonObject r10 = r12.ext;
    L29:
        if ((r22 & 128) == 0) goto L32;
        r5 = r12.onClickCallback;
    L32:
        if ((r22 & 256) == 0) goto L34;
        Function0<Unit> r1 = r12.onCardClickCallback;
    L36:
        return r12.copy(r6, r7, r8, r9, r2, r4, r10, r5, r1);
    L34:
        r1 = r3;
        goto L36
    L27:
        r10 = r19;
        goto L29
    L17:
        r9 = r16;
        goto L19
    L13:
        r8 = r15;
        goto L15
    L9:
        r7 = r14;
        goto L11
    L5:
        r6 = r13;
        goto L7
    }

    public final void addOnViewClickCallback(String r3, Function0<Unit> r4) {
        Function0<Unit> r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "viewId");
        Intrinsics.checkNotNullParameter(r5, "onClick");
        this.onClickCallback.put(r3, r5);
    }

    public final String component1() {
        return this.templateId;
    }

    public final Object component2() {
        return this.templateData;
    }

    public final Boolean component3() {
        return this.isDefault;
    }

    public final View component4() {
        return this.view;
    }

    public final List<TransitionAnimation> component5() {
        return this.inAnimation;
    }

    public final List<TransitionAnimation> component6() {
        return this.outAnimation;
    }

    public final JsonObject component7() {
        return this.ext;
    }

    public final Map<String, Function0<Unit>> component8() {
        return this.onClickCallback;
    }

    public final Function0<Unit> component9() {
        return this.onCardClickCallback;
    }

    public final IslandWidget copy(String r13, Object r14, Boolean r15, View r16, List<? extends TransitionAnimation> r17, List<? extends TransitionAnimation> r18, JsonObject r19, Map<String, Function0<Unit>> r20, Function0<Unit> r21) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.memorydata.plugin");
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin");
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r20, Map.class, "com.obric.memorydata.plugin");
        Function0 r11 = (Function0) ZeusTransformUtils.wrapperContextForParams(r21, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "templateId");
        Intrinsics.checkNotNullParameter(r14, "templateData");
        Intrinsics.checkNotNullParameter(r10, "onClickCallback");
        return new IslandWidget(r13, r14, r15, r16, r7, r8, r19, r10, r11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, IslandWidget.class) == true) goto L8;
        return false;
    L8:
        IslandWidget r6 = (IslandWidget) ZeusTransformUtils.preCheckCast(r5, IslandWidget.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.templateId, r6.templateId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.templateData, r6.templateData) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.isDefault, r6.isDefault) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.view, r6.view) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.inAnimation, r6.inAnimation) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.outAnimation, r6.outAnimation) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.ext, r6.ext) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.onClickCallback, r6.onClickCallback) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.onCardClickCallback, r6.onCardClickCallback) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final Function0<Unit> findOnViewClickCallbackById(String r2) {
        Intrinsics.checkNotNullParameter(r2, "viewId");
        return (Function0) ZeusTransformUtils.preCheckCast(this.onClickCallback.get(r2), Function0.class, "com.obric.memorydata.plugin");
    }

    public final JsonObject getExt() {
        return this.ext;
    }

    public final List<TransitionAnimation> getInAnimation() {
        return this.inAnimation;
    }

    public final Function0<Unit> getOnCardClickCallback() {
        return this.onCardClickCallback;
    }

    public final Map<String, Function0<Unit>> getOnClickCallback() {
        return this.onClickCallback;
    }

    public final List<TransitionAnimation> getOutAnimation() {
        return this.outAnimation;
    }

    public final Object getTemplateData() {
        return this.templateData;
    }

    public final String getTemplateId() {
        return this.templateId;
    }

    public final View getView() {
        return this.view;
    }

    public int hashCode() {
        int r0 = ((this.templateId.hashCode() * 31) + this.templateData.hashCode()) * 31;
        Boolean r1 = this.isDefault;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        View r5 = this.view;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        List<? extends TransitionAnimation> r8 = this.inAnimation;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        List<? extends TransitionAnimation> r11 = this.outAnimation;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        JsonObject r14 = this.ext;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (((r13 + r15) * 31) + this.onClickCallback.hashCode()) * 31;
        Function0<Unit> r17 = this.onCardClickCallback;
        if (r17 == null) goto L27;
        r2 = r17.hashCode();
    L27:
        return r16 + r2;
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final Boolean isDefault() {
        return this.isDefault;
    }

    public final void setExt(JsonObject r1) {
        this.ext = r1;
    }

    public final void setInAnimation(List<? extends TransitionAnimation> r3) {
        this.inAnimation = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    public final void setOnCardClickCallback(Function0<Unit> r3) {
        this.onCardClickCallback = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
    }

    public final void setOnClickCallback(Map<String, Function0<Unit>> r3) {
        Map<String, Function0<Unit>> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.onClickCallback = r4;
    }

    public final void setOutAnimation(List<? extends TransitionAnimation> r3) {
        this.outAnimation = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    public final void setTemplateData(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.templateData = r2;
    }

    public final void setView(View r1) {
        this.view = r1;
    }

    public String toString() {
        return "IslandWidget(isDefault=" + this.isDefault + ", templateData=" + this.templateData + ", templateId='" + this.templateId + "', ext=" + this.ext + ", inAnimation=" + this.inAnimation + ", outAnimation=" + this.outAnimation + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parcel");
        r4.writeString(this.templateId);
        Object r6 = this.templateData;
        String r2 = null;
        if (ZeusTransformUtils.instanceOf(r6, String.class) == false) goto L5;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin");
    L6:
        if (r7 == null) goto L8;
        r4.writeString(r7);
        Unit r8 = Unit.INSTANCE;
    L9:
        if (r8 != null) goto L11;
        r4.writeString(new Gson().toJson(this.templateData));
    L11:
        r4.writeValue(this.isDefault);
        r4.writeValue(null);
        r4.writeValue(null);
        r4.writeString(new Gson().toJson(this.inAnimation));
        r4.writeString(new Gson().toJson(this.outAnimation));
        JsonObject r3 = this.ext;
        if (r3 == null) goto L14;
        r2 = new Gson().toJson((JsonElement) ZeusTransformUtils.preCheckCast(r3, JsonElement.class, "com.obric.memorydata.plugin"));
    L14:
        r4.writeString(r2);
        return;
    L8:
        r8 = null;
        goto L9
    L5:
        r7 = null;
        goto L6
    }
}
