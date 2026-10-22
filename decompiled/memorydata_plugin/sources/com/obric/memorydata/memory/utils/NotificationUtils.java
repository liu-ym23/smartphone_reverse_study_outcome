package com.obric.memorydata.memory.utils;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/obric/memorydata/memory/utils/NotificationUtils;", "", "<init>", "()V", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NotificationUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f11528a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy<Context> f11529b = null;

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0002'(B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000f\u001a\u00020\u0010J*\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J$\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J\u0010\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\u0010\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001dH\u0002J\u000e\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020#J\u001a\u0010$\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016J\b\u0010%\u001a\u00020&H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006)"}, d2 = {"Lcom/obric/memorydata/memory/utils/NotificationUtils$Companion;", "", "<init>", "()V", "CHANNEL_ID", "", "NOTIFICATION_CLICK_ACTION", "NOTIFICATION_DELETE_ACTION", "TAG", "CONTEXT", "Landroid/content/Context;", "getCONTEXT", "()Landroid/content/Context;", "CONTEXT$delegate", "Lkotlin/Lazy;", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "showMemory", OaidModel.KEY_ID, "state", "", "entity", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "oldEntity", "onPassiveMemoryBegin", "onPassiveMemorySuccess", "createDeleteIntent", "Landroid/app/PendingIntent;", "transformEntity2Content", "Lcom/obric/memorydata/memory/utils/NotificationUtils$Companion$NotificationContent;", "onPassiveMemoryFailed", "createClickIntent", Params.CONTENT, "showCaptureAnim", "duration", "", "onSaveAssistantMemory", "hasNotificationPermission", "", "NotificationContent", "NotificationReceiver", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {

        @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0006\u0010\u0017\u001a\u00020\bJ\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\bHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006#"}, d2 = {"Lcom/obric/memorydata/memory/utils/NotificationUtils$Companion$NotificationContent;", "Landroid/os/Parcelable;", "entity", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "title", "", Params.CONTENT, "icon", "", "<init>", "(Lcom/obric/capabilitykit/entity/memory/MemoryEntity;Ljava/lang/String;Ljava/lang/String;I)V", "getEntity", "()Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "getTitle", "()Ljava/lang/String;", "getContent", "getIcon", "()I", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class NotificationContent implements Parcelable {
            public static final Parcelable.Creator<NotificationContent> CREATOR = null;
            private final String content;
            private final MemoryEntity entity;
            private final int icon;
            private final String title;

            @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
            public static final class a implements Parcelable.Creator<NotificationContent> {
                public a() {
                }

                public final NotificationContent a(Parcel r4) {
                    Intrinsics.checkNotNullParameter(r4, "parcel");
                    return new NotificationContent((MemoryEntity) ZeusTransformUtils.preCheckCast(r4.readParcelable(NotificationContent.class.getClassLoader()), MemoryEntity.class, "com.obric.memorydata.plugin"), r4.readString(), r4.readString(), r4.readInt());
                }

                public final NotificationContent[] a(int r1) {
                    return new NotificationContent[r1];
                }

                @Override // android.os.Parcelable.Creator
                public /* synthetic */ NotificationContent createFromParcel(Parcel r1) {
                    return a(r1);
                }

                @Override // android.os.Parcelable.Creator
                public /* synthetic */ NotificationContent[] newArray(int r1) {
                    return a(r1);
                }
            }

            static {
                CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new a(), Parcelable.Creator.class, "com.obric.memorydata.plugin");
            }

            public NotificationContent(MemoryEntity r2, String r3, String r4, int r5) {
                Intrinsics.checkNotNullParameter(r2, "entity");
                Intrinsics.checkNotNullParameter(r3, "title");
                Intrinsics.checkNotNullParameter(r4, Params.CONTENT);
                this.entity = r2;
                this.title = r3;
                this.content = r4;
                this.icon = r5;
            }

            public /* synthetic */ NotificationContent(MemoryEntity r1, String r2, String r3, int r4, int r5, DefaultConstructorMarker r6) {
                if ((r5 & 8) == 0) goto L5;
                r4 = ZeusTransformUtils.mapRes(R.drawable.smart_memory_icon, "drawable", "smart_memory_icon");
            L5:
                this(r1, r2, r3, r4);
            }

            public static /* synthetic */ NotificationContent copy$default(NotificationContent r0, MemoryEntity r1, String r2, String r3, int r4, int r5, Object r6) {
                if ((r5 & 1) == 0) goto L6;
                r1 = r0.entity;
            L6:
                if ((r5 & 2) == 0) goto L9;
                r2 = r0.title;
            L9:
                if ((r5 & 4) == 0) goto L12;
                r3 = r0.content;
            L12:
                if ((r5 & 8) == 0) goto L15;
                r4 = r0.icon;
            L15:
                return r0.copy(r1, r2, r3, r4);
            }

            public final MemoryEntity component1() {
                return this.entity;
            }

            public final String component2() {
                return this.title;
            }

            public final String component3() {
                return this.content;
            }

            public final int component4() {
                return this.icon;
            }

            public final NotificationContent copy(MemoryEntity r1, String r2, String r3, int r4) {
                Intrinsics.checkNotNullParameter(r1, "entity");
                Intrinsics.checkNotNullParameter(r2, "title");
                Intrinsics.checkNotNullParameter(r3, Params.CONTENT);
                return new NotificationContent(r1, r2, r3, r4);
            }

            @Override // android.os.Parcelable
            public final int describeContents() {
                return 0;
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, NotificationContent.class) == true) goto L8;
                return false;
            L8:
                NotificationContent r6 = (NotificationContent) ZeusTransformUtils.preCheckCast(r5, NotificationContent.class, "com.obric.memorydata.plugin");
                if (Intrinsics.areEqual(this.entity, r6.entity) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.title, r6.title) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.content, r6.content) == true) goto L18;
                return false;
            L18:
                if (this.icon == r6.icon) goto L20;
                return false;
            L20:
                return true;
            }

            public final String getContent() {
                return this.content;
            }

            public final MemoryEntity getEntity() {
                return this.entity;
            }

            public final int getIcon() {
                return this.icon;
            }

            public final String getTitle() {
                return this.title;
            }

            public int hashCode() {
                return (((((this.entity.hashCode() * 31) + this.title.hashCode()) * 31) + this.content.hashCode()) * 31) + Integer.hashCode(this.icon);
            }

            public String toString() {
                return "NotificationContent(entity=" + this.entity + ", title=" + this.title + ", content=" + this.content + ", icon=" + this.icon + ')';
            }

            @Override // android.os.Parcelable
            public final void writeToParcel(Parcel r4, int r5) {
                Intrinsics.checkNotNullParameter(r4, "dest");
                r4.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.entity, Parcelable.class, "com.obric.memorydata.plugin"), r5);
                r4.writeString(this.title);
                r4.writeString(this.content);
                r4.writeInt(this.icon);
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final Context a() {
            return (Context) ZeusTransformUtils.preCheckCast(NotificationUtils.a().getValue(), Context.class, "com.obric.memorydata.plugin");
        }
    }

    static {
        f11528a = new Companion(null);
        f11529b = LazyKt.lazy($$Lambda$NotificationUtils$P9v4hWnAHW99MY382N5Q9kGGoD8.INSTANCE);
    }

    public static final /* synthetic */ Lazy a() {
        return f11529b;
    }

    private static final Context b() {
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ Context lambda$P9v4hWnAHW99MY382N5Q9kGGoD8() {
        return b();
    }
}
