package com.obric.memorydata.utils.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\t\u0018\u0000 22\u00020\u0001:\u000523456B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\nJ\u000e\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\nJ\u000e\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0018J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u000e\u0010 \u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020!J\u0006\u0010\"\u001a\u00020\u000eJ\u0006\u0010#\u001a\u00020\fJ\u000e\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020!J\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'J\u000e\u0010)\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020!J<\u0010*\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020!2\u0006\u0010,\u001a\u00020!2\u0006\u0010\u0017\u001a\u00020!2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!0.2\b\b\u0001\u0010/\u001a\u00020\u001fJ0\u00100\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020!2\u0006\u0010,\u001a\u00020!2\u0006\u0010\u0017\u001a\u00020!2\b\b\u0001\u0010/\u001a\u00020\u001f2\u0006\u00101\u001a\u00020!R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/obric/memorydata/utils/notification/UniversalNotificationUtils;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "notificationManager", "Landroid/app/NotificationManager;", "clickListeners", "", "Lcom/obric/memorydata/utils/notification/UniversalNotificationUtils$OnNotificationClickListener;", "isInit", "", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "createDefaultChannel", "createNotificationChannel", "config", "Lcom/obric/memorydata/utils/notification/UniversalNotificationUtils$ChannelConfig;", "addOnNotificationClickListener", "listener", "removeOnNotificationClickListener", "showNotification", Params.CONTENT, "Lcom/obric/memorydata/utils/notification/UniversalNotificationUtils$NotificationContent;", "buildNotification", "Landroid/app/Notification;", "createClickIntent", "Landroid/app/PendingIntent;", "createDeleteIntent", "notificationId", "", "cancelNotification", "", "cancelAllNotifications", "hasNotificationPermission", "hasChannelNotificationPermission", "channelId", "getNotificationChannels", "", "Landroid/app/NotificationChannel;", "deleteNotificationChannel", "showSimpleNotification", OaidModel.KEY_ID, "title", "extras", "", "smallIcon", "showBigTextNotification", "bigText", "Companion", "NotificationContent", "ChannelConfig", "OnNotificationClickListener", "NotificationReceiver", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UniversalNotificationUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f13251a = null;
    private static volatile UniversalNotificationUtils f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f13252b;
    private final NotificationManager c;
    private final List<c> d;
    private boolean e;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b#\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B}\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\f\u0012\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001aJ\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0007HÆ\u0003J\t\u0010+\u001a\u00020\fHÆ\u0003J\t\u0010,\u001a\u00020\fHÆ\u0003J\t\u0010-\u001a\u00020\fHÆ\u0003J\u0015\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0010HÆ\u0003J\u008a\u0001\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0010HÆ\u0001¢\u0006\u0002\u00100J\u0006\u00101\u001a\u00020\u0007J\u0013\u00102\u001a\u00020\f2\b\u00103\u001a\u0004\u0018\u000104HÖ\u0003J\t\u00105\u001a\u00020\u0007HÖ\u0001J\t\u00106\u001a\u00020\u0003HÖ\u0001J\u0016\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0011\u0010\u000e\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u001d\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0010¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u0006<"}, d2 = {"Lcom/obric/memorydata/utils/notification/UniversalNotificationUtils$NotificationContent;", "Landroid/os/Parcelable;", OaidModel.KEY_ID, "", "title", Params.CONTENT, "smallIcon", "", "largeIcon", "channelId", "priority", "autoCancel", "", "showWhen", "bigText", "extras", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/String;IZZZLjava/util/Map;)V", "getId", "()Ljava/lang/String;", "getTitle", "getContent", "getSmallIcon", "()I", "getLargeIcon", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getChannelId", "getPriority", "getAutoCancel", "()Z", "getShowWhen", "getBigText", "getExtras", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/String;IZZZLjava/util/Map;)Lcom/obric/memorydata/utils/notification/UniversalNotificationUtils$NotificationContent;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class NotificationContent implements Parcelable {
        public static final Parcelable.Creator<NotificationContent> CREATOR = null;
        private final boolean autoCancel;
        private final boolean bigText;
        private final String channelId;
        private final String content;
        private final Map<String, String> extras;
        private final String id;
        private final Integer largeIcon;
        private final int priority;
        private final boolean showWhen;
        private final int smallIcon;
        private final String title;

        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class a implements Parcelable.Creator<NotificationContent> {
            public a() {
            }

            public final NotificationContent a(Parcel r15) {
                Intrinsics.checkNotNullParameter(r15, "parcel");
                String r1 = r15.readString();
                String r2 = r15.readString();
                String r3 = r15.readString();
                int r4 = r15.readInt();
                if (r15.readInt() != 0) goto L5;
                Integer r14 = null;
            L6:
                Integer r5 = r14;
                String r6 = r15.readString();
                int r7 = r15.readInt();
                int r8 = 0;
                if (r15.readInt() == 0) goto L9;
                boolean r16 = true;
            L11:
                if (r15.readInt() == 0) goto L13;
                boolean r9 = true;
            L15:
                if (r15.readInt() == 0) goto L17;
                boolean r10 = true;
            L18:
                int r0 = r15.readInt();
                LinkedHashMap r11 = new LinkedHashMap(r0);
            L19:
                if (r8 == r0) goto L22;
                r11.put(r15.readString(), r15.readString());
                r8 = r8 + 1;
                goto L19
            L22:
                return new NotificationContent(r1, r2, r3, r4, r5, r6, r7, r16, r9, r10, (Map) ZeusTransformUtils.preCheckCast(r11, Map.class, "com.obric.memorydata.plugin"));
            L17:
                r10 = false;
                goto L18
            L13:
                r9 = false;
                goto L15
            L9:
                r16 = false;
                goto L11
            L5:
                r14 = Integer.valueOf(r15.readInt());
                goto L6
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

        public NotificationContent(String r3, String r4, String r5, int r6, Integer r7, String r8, int r9, boolean r10, boolean r11, boolean r12, Map<String, String> r13) {
            Map<String, String> r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, OaidModel.KEY_ID);
            Intrinsics.checkNotNullParameter(r4, "title");
            Intrinsics.checkNotNullParameter(r5, Params.CONTENT);
            Intrinsics.checkNotNullParameter(r8, "channelId");
            Intrinsics.checkNotNullParameter(r14, "extras");
            this.id = r3;
            this.title = r4;
            this.content = r5;
            this.smallIcon = r6;
            this.largeIcon = r7;
            this.channelId = r8;
            this.priority = r9;
            this.autoCancel = r10;
            this.showWhen = r11;
            this.bigText = r12;
            this.extras = r14;
        }

        public /* synthetic */ NotificationContent(String r16, String r17, String r18, int r19, Integer r20, String r21, int r22, boolean r23, boolean r24, boolean r25, Map r26, int r27, DefaultConstructorMarker r28) {
            Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r26, Map.class, "com.obric.memorydata.plugin");
            if ((r27 & 16) == 0) goto L5;
            Integer r8 = null;
        L7:
            if ((r27 & 32) == 0) goto L9;
            String r9 = "DEFAULT_NOTIFICATION_CHANNEL";
        L11:
            if ((r27 & 64) == 0) goto L13;
            int r10 = 1;
        L15:
            if ((r27 & 128) == 0) goto L17;
            boolean r11 = true;
        L19:
            if ((r27 & 256) == 0) goto L21;
            boolean r12 = true;
        L23:
            if ((r27 & 512) == 0) goto L25;
            boolean r13 = true;
        L27:
            if ((r27 & 1024) == 0) goto L29;
            r1 = MapsKt.emptyMap();
        L29:
            this(r16, r17, r18, r19, r8, r9, r10, r11, r12, r13, r1);
            return;
        L25:
            r13 = r25;
            goto L27
        L21:
            r12 = r24;
            goto L23
        L17:
            r11 = r23;
            goto L19
        L13:
            r10 = r22;
            goto L15
        L9:
            r9 = r21;
            goto L11
        L5:
            r8 = r20;
            goto L7
        }

        public static /* synthetic */ NotificationContent copy$default(NotificationContent r13, String r14, String r15, String r16, int r17, Integer r18, String r19, int r20, boolean r21, boolean r22, boolean r23, Map r24, int r25, Object r26) {
            Map<String, String> r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r24, Map.class, "com.obric.memorydata.plugin");
            if ((r25 & 1) == 0) goto L5;
            String r3 = r13.id;
        L7:
            if ((r25 & 2) == 0) goto L9;
            String r4 = r13.title;
        L11:
            if ((r25 & 4) == 0) goto L13;
            String r5 = r13.content;
        L15:
            if ((r25 & 8) == 0) goto L17;
            int r6 = r13.smallIcon;
        L19:
            if ((r25 & 16) == 0) goto L21;
            Integer r7 = r13.largeIcon;
        L23:
            if ((r25 & 32) == 0) goto L25;
            String r8 = r13.channelId;
        L27:
            if ((r25 & 64) == 0) goto L29;
            int r9 = r13.priority;
        L31:
            if ((r25 & 128) == 0) goto L33;
            boolean r10 = r13.autoCancel;
        L35:
            if ((r25 & 256) == 0) goto L37;
            boolean r11 = r13.showWhen;
        L39:
            if ((r25 & 512) == 0) goto L41;
            boolean r12 = r13.bigText;
        L43:
            if ((r25 & 1024) == 0) goto L46;
            r2 = r13.extras;
        L46:
            return r13.copy(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r2);
        L41:
            r12 = r23;
            goto L43
        L37:
            r11 = r22;
            goto L39
        L33:
            r10 = r21;
            goto L35
        L29:
            r9 = r20;
            goto L31
        L25:
            r8 = r19;
            goto L27
        L21:
            r7 = r18;
            goto L23
        L17:
            r6 = r17;
            goto L19
        L13:
            r5 = r16;
            goto L15
        L9:
            r4 = r15;
            goto L11
        L5:
            r3 = r14;
            goto L7
        }

        public final String component1() {
            return this.id;
        }

        public final boolean component10() {
            return this.bigText;
        }

        public final Map<String, String> component11() {
            return this.extras;
        }

        public final String component2() {
            return this.title;
        }

        public final String component3() {
            return this.content;
        }

        public final int component4() {
            return this.smallIcon;
        }

        public final Integer component5() {
            return this.largeIcon;
        }

        public final String component6() {
            return this.channelId;
        }

        public final int component7() {
            return this.priority;
        }

        public final boolean component8() {
            return this.autoCancel;
        }

        public final boolean component9() {
            return this.showWhen;
        }

        public final NotificationContent copy(String r14, String r15, String r16, int r17, Integer r18, String r19, int r20, boolean r21, boolean r22, boolean r23, Map<String, String> r24) {
            Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r24, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r14, OaidModel.KEY_ID);
            Intrinsics.checkNotNullParameter(r15, "title");
            Intrinsics.checkNotNullParameter(r16, Params.CONTENT);
            Intrinsics.checkNotNullParameter(r19, "channelId");
            Intrinsics.checkNotNullParameter(r12, "extras");
            return new NotificationContent(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r12);
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
            if (Intrinsics.areEqual(this.id, r6.id) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.title, r6.title) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.content, r6.content) == true) goto L18;
            return false;
        L18:
            if (this.smallIcon == r6.smallIcon) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.largeIcon, r6.largeIcon) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.channelId, r6.channelId) == true) goto L27;
            return false;
        L27:
            if (this.priority == r6.priority) goto L30;
            return false;
        L30:
            if (this.autoCancel == r6.autoCancel) goto L33;
            return false;
        L33:
            if (this.showWhen == r6.showWhen) goto L36;
            return false;
        L36:
            if (this.bigText == r6.bigText) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.extras, r6.extras) == true) goto L41;
            return false;
        L41:
            return true;
        }

        public final boolean getAutoCancel() {
            return this.autoCancel;
        }

        public final boolean getBigText() {
            return this.bigText;
        }

        public final String getChannelId() {
            return this.channelId;
        }

        public final String getContent() {
            return this.content;
        }

        public final Map<String, String> getExtras() {
            return this.extras;
        }

        public final String getId() {
            return this.id;
        }

        public final Integer getLargeIcon() {
            return this.largeIcon;
        }

        public final int getPriority() {
            return this.priority;
        }

        public final boolean getShowWhen() {
            return this.showWhen;
        }

        public final int getSmallIcon() {
            return this.smallIcon;
        }

        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            int r0 = ((((((this.id.hashCode() * 31) + this.title.hashCode()) * 31) + this.content.hashCode()) * 31) + Integer.hashCode(this.smallIcon)) * 31;
            Integer r1 = this.largeIcon;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return ((((((((((((r0 + r2) * 31) + this.channelId.hashCode()) * 31) + Integer.hashCode(this.priority)) * 31) + Boolean.hashCode(this.autoCancel)) * 31) + Boolean.hashCode(this.showWhen)) * 31) + Boolean.hashCode(this.bigText)) * 31) + this.extras.hashCode();
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("NotificationContent(id=").append(this.id).append(", title=").append(this.title).append(", content=").append(this.content).append(", smallIcon=").append(this.smallIcon).append(", largeIcon=").append(this.largeIcon).append(", channelId=").append(this.channelId).append(", priority=").append(this.priority).append(", autoCancel=").append(this.autoCancel).append(", showWhen=").append(this.showWhen).append(", bigText=").append(this.bigText).append(", extras=").append(this.extras).append(')');
            return r0.toString();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r4, int r5) {
            Intrinsics.checkNotNullParameter(r4, "dest");
            r4.writeString(this.id);
            r4.writeString(this.title);
            r4.writeString(this.content);
            r4.writeInt(this.smallIcon);
            Integer r6 = this.largeIcon;
            if (r6 != null) goto L5;
            int r7 = 0;
        L6:
            r4.writeInt(r7);
            r4.writeString(this.channelId);
            r4.writeInt(this.priority);
            r4.writeInt(this.autoCancel ? 1 : 0);
            r4.writeInt(this.showWhen ? 1 : 0);
            r4.writeInt(this.bigText ? 1 : 0);
            Map<String, String> r3 = this.extras;
            r4.writeInt(r3.size());
            Iterator<Map.Entry<String, String>> r8 = r3.entrySet().iterator();
        L8:
            if (r8.hasNext() == false) goto L10;
            Map.Entry<String, String> r9 = r8.next();
            r4.writeString((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r9, Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), String.class, "com.obric.memorydata.plugin"));
            r4.writeString((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r9, Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), String.class, "com.obric.memorydata.plugin"));
            goto L8
        L10:
            return;
        L5:
            r4.writeInt(1);
            r7 = r6.intValue();
            goto L6
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0017¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/utils/notification/UniversalNotificationUtils$NotificationReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "onReceive", "", "context", "Landroid/content/Context;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class NotificationReceiver extends PluginBroadcastReceiver {
        public NotificationReceiver() {
        }

        public void onReceive(Context r4, Intent r5) {
            Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
            if (r3 == null) goto L33;
            if (r5 != null) goto L6;
            return;
        L6:
            if (Intrinsics.areEqual(r5.getPackage(), r3.getPackageName()) == false) goto L40;
            String r6 = r5.getAction();
            if (r6 == null) goto L37;
            int r1 = r6.hashCode();
            if (r1 == (-571843916)) goto L25;
            if (r1 == 1227761471) goto L16;
            return;
        L16:
            if (r6.equals("com.obric.memorydata.util.NOTIFICATION_CLICK") == false) goto L42;
            r5.setExtrasClassLoader(NotificationContent.class.getClassLoader());
            NotificationContent r7 = (NotificationContent) ZeusTransformUtils.preCheckCast(r5.getParcelableExtra(Params.CONTENT, NotificationContent.class), NotificationContent.class, "com.obric.memorydata.plugin");
            if (r7 == null) goto L38;
            Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(UniversalNotificationUtils.b(UniversalNotificationUtils.f13251a.a(r3)), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L22:
            if (r8.hasNext() == false) goto L44;
            ((c) ZeusTransformUtils.preCheckCast(r8.next(), c.class, "com.obric.memorydata.plugin")).a(r7);
            goto L22
        L44:
            return;
        L38:
            return;
        L42:
            return;
        L25:
            if (r6.equals("com.obric.memorydata.util.NOTIFICATION_DELETE") == false) goto L43;
            int r9 = r5.getIntExtra("notificationId", -1);
            if (r9 == (-1)) goto L39;
            Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(UniversalNotificationUtils.b(UniversalNotificationUtils.f13251a.a(r3)), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L31:
            if (r10.hasNext() == false) goto L45;
            ((c) ZeusTransformUtils.preCheckCast(r10.next(), c.class, "com.obric.memorydata.plugin")).a(r9);
            goto L31
        L45:
            return;
        L39:
            return;
        L43:
            return;
        L37:
            return;
        L40:
            return;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b!\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\tHÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J\t\u0010\"\u001a\u00020\tHÆ\u0003J\t\u0010#\u001a\u00020\tHÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003Jc\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u0007HÆ\u0001J\u0013\u0010&\u001a\u00020\t2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\u0007HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015¨\u0006*"}, d2 = {"Lcom/obric/memorydata/utils/notification/UniversalNotificationUtils$ChannelConfig;", "", "channelId", "", "channelName", "channelDescription", "importance", "", "showBadge", "", "enableLights", "enableVibration", "bypassDnd", "lockscreenVisibility", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZZZZI)V", "getChannelId", "()Ljava/lang/String;", "getChannelName", "getChannelDescription", "getImportance", "()I", "getShowBadge", "()Z", "getEnableLights", "getEnableVibration", "getBypassDnd", "getLockscreenVisibility", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f13253a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f13254b;
        private final String c;
        private final int d;
        private final boolean e;
        private final boolean f;
        private final boolean g;
        private final boolean h;
        private final int i;

        public a(String r2, String r3, String r4, int r5, boolean r6, boolean r7, boolean r8, boolean r9, int r10) {
            Intrinsics.checkNotNullParameter(r2, "channelId");
            Intrinsics.checkNotNullParameter(r3, "channelName");
            Intrinsics.checkNotNullParameter(r4, "channelDescription");
            this.f13253a = r2;
            this.f13254b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            this.i = r10;
        }

        public /* synthetic */ a(String r13, String r14, String r15, int r16, boolean r17, boolean r18, boolean r19, boolean r20, int r21, int r22, DefaultConstructorMarker r23) {
            if ((r22 & 8) == 0) goto L5;
            int r6 = 4;
        L7:
            if ((r22 & 16) == 0) goto L9;
            boolean r7 = true;
        L11:
            if ((r22 & 32) == 0) goto L13;
            boolean r8 = true;
        L15:
            if ((r22 & 64) == 0) goto L17;
            boolean r9 = true;
        L19:
            if ((r22 & 128) == 0) goto L21;
            boolean r10 = false;
        L23:
            if ((r22 & 256) == 0) goto L25;
            int r11 = 1;
        L26:
            this(r13, r14, r15, r6, r7, r8, r9, r10, r11);
            return;
        L25:
            r11 = r21;
            goto L26
        L21:
            r10 = r20;
            goto L23
        L17:
            r9 = r19;
            goto L19
        L13:
            r8 = r18;
            goto L15
        L9:
            r7 = r17;
            goto L11
        L5:
            r6 = r16;
            goto L7
        }

        public final String a() {
            return this.f13253a;
        }

        public final String b() {
            return this.f13254b;
        }

        public final String c() {
            return this.c;
        }

        public final int d() {
            return this.d;
        }

        public final boolean e() {
            return this.e;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f13253a, r6.f13253a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f13254b, r6.f13254b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L27;
            return false;
        L27:
            if (this.g == r6.g) goto L30;
            return false;
        L30:
            if (this.h == r6.h) goto L33;
            return false;
        L33:
            if (this.i == r6.i) goto L35;
            return false;
        L35:
            return true;
        }

        public final boolean f() {
            return this.f;
        }

        public final boolean g() {
            return this.g;
        }

        public final boolean h() {
            return this.h;
        }

        public int hashCode() {
            return (((((((((((((((this.f13253a.hashCode() * 31) + this.f13254b.hashCode()) * 31) + this.c.hashCode()) * 31) + Integer.hashCode(this.d)) * 31) + Boolean.hashCode(this.e)) * 31) + Boolean.hashCode(this.f)) * 31) + Boolean.hashCode(this.g)) * 31) + Boolean.hashCode(this.h)) * 31) + Integer.hashCode(this.i);
        }

        public final int i() {
            return this.i;
        }

        public String toString() {
            return "ChannelConfig(channelId=" + this.f13253a + ", channelName=" + this.f13254b + ", channelDescription=" + this.c + ", importance=" + this.d + ", showBadge=" + this.e + ", enableLights=" + this.f + ", enableVibration=" + this.g + ", bypassDnd=" + this.h + ", lockscreenVisibility=" + this.i + ')';
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/utils/notification/UniversalNotificationUtils$Companion;", "", "<init>", "()V", "DEFAULT_CHANNEL_ID", "", "DEFAULT_CHANNEL_NAME", "DEFAULT_CHANNEL_DESCRIPTION", "NOTIFICATION_CLICK_ACTION", "NOTIFICATION_DELETE_ACTION", "SMALL_ICON_USE_APP_ICON", "STATUS_BAR_USE_APP_ICON", "TAG", "INSTANCE", "Lcom/obric/memorydata/utils/notification/UniversalNotificationUtils;", "getInstance", "context", "Landroid/content/Context;", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r1) {
            this();
        }

        public final UniversalNotificationUtils a(Context r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "context");
            UniversalNotificationUtils r0 = UniversalNotificationUtils.c();
            if (r0 != null) goto L13;
            monitor-enter(this);
            r0 = UniversalNotificationUtils.c();     // Catch: Throwable -> L10
            if (r0 != null) goto L8;
            Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            Intrinsics.checkNotNullExpressionValue(r6, "getApplicationContext(...)");     // Catch: Throwable -> L10
            r0 = new UniversalNotificationUtils(r6, null);     // Catch: Throwable -> L10
            b r7 = UniversalNotificationUtils.f13251a;     // Catch: Throwable -> L10
            UniversalNotificationUtils.a(r0);     // Catch: Throwable -> L10
        L8:
            monitor-exit(this);
        L10:
            th = move-exception;
            throw th;
        L13:
            return r0;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/utils/notification/UniversalNotificationUtils$OnNotificationClickListener;", "", "onNotificationClick", "", Params.CONTENT, "Lcom/obric/memorydata/utils/notification/UniversalNotificationUtils$NotificationContent;", "onNotificationDelete", "notificationId", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface c {

        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class a {
            public static void a(c r1, int r2) {
                c r3 = (c) ZeusTransformUtils.wrapperContextForParams(r1, c.class, "com.obric.memorydata.plugin");
            }
        }

        void a(int r1);

        void a(NotificationContent r1);
    }

    static {
        f13251a = new b(null);
    }

    private UniversalNotificationUtils(Context r3) {
        Context r4 = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.f13252b = r4;
        Object r5 = r4.getSystemService("notification");
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type android.app.NotificationManager");
        this.c = (NotificationManager) ZeusTransformUtils.preCheckCast(r5, NotificationManager.class, "com.obric.memorydata.plugin");
        this.d = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
    }

    public /* synthetic */ UniversalNotificationUtils(Context r2, DefaultConstructorMarker r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Notification a(UniversalNotificationUtils r0, NotificationContent r1) {
        return r0.b(r1);
    }

    private final PendingIntent a(int r3) {
        Intent r0 = new Intent("com.obric.memorydata.util.NOTIFICATION_DELETE");
        r0.setPackage(this.f13252b.getPackageName());
        r0.putExtra("notificationId", r3);
        PendingIntent r2 = PendingIntent.getBroadcast(this.f13252b, Random.Default.nextInt(), r0, 201326592);
        Intrinsics.checkNotNullExpressionValue(r2, "getBroadcast(...)");
        return r2;
    }

    public static final /* synthetic */ void a(UniversalNotificationUtils r0) {
        f = r0;
    }

    private final Notification b(NotificationContent r5) {
        NotificationCompat.Builder r4 = new NotificationCompat.Builder(this.f13252b, r5.getChannelId()).setContentTitle((CharSequence) ZeusTransformUtils.preCheckCast(r5.getTitle(), CharSequence.class, "com.obric.memorydata.plugin")).setContentText((CharSequence) ZeusTransformUtils.preCheckCast(r5.getContent(), CharSequence.class, "com.obric.memorydata.plugin")).setSmallIcon(r5.getSmallIcon()).setPriority(r5.getPriority()).setAutoCancel(r5.getAutoCancel()).setShowWhen(r5.getShowWhen()).setWhen(System.currentTimeMillis()).setContentIntent(c(r5)).setDeleteIntent(a(r5.getId().hashCode()));
        Intrinsics.checkNotNullExpressionValue(r4, "setDeleteIntent(...)");
        if (r5.getBigText() == false) goto L5;
        r4.setStyle((NotificationCompat.Style) ZeusTransformUtils.preCheckCast(new NotificationCompat.BigTextStyle().bigText((CharSequence) ZeusTransformUtils.preCheckCast(r5.getContent(), CharSequence.class, "com.obric.memorydata.plugin")), NotificationCompat.Style.class, "com.obric.memorydata.plugin"));
    L5:
        Iterator<Map.Entry<String, String>> r6 = r5.getExtras().entrySet().iterator();
    L7:
        if (r6.hasNext() == false) goto L9;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.memorydata.plugin");
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.getValue(), String.class, "com.obric.memorydata.plugin");
        Bundle r3 = new Bundle();
        r3.putString(r1, r2);
        r4.addExtras(r3);
        goto L7
    L9:
        r4.getExtras().putBoolean("small_icon_use_app_icon", false);
        r4.getExtras().putBoolean("status_bar_use_app_icon", false);
        Notification r7 = r4.build();
        Intrinsics.checkNotNullExpressionValue(r7, "build(...)");
        return r7;
    }

    public static final /* synthetic */ List b(UniversalNotificationUtils r0) {
        return r0.d;
    }

    public static final /* synthetic */ NotificationManager c(UniversalNotificationUtils r0) {
        return r0.c;
    }

    private final PendingIntent c(NotificationContent r4) {
        Intent r0 = new Intent("com.obric.memorydata.util.NOTIFICATION_CLICK");
        r0.setPackage(this.f13252b.getPackageName());
        r0.putExtra(Params.CONTENT, (Parcelable) ZeusTransformUtils.preCheckCast(r4, Parcelable.class, "com.obric.memorydata.plugin"));
        PendingIntent r3 = PendingIntent.getBroadcast(this.f13252b, r4.getId().hashCode(), r0, 201326592);
        Intrinsics.checkNotNullExpressionValue(r3, "getBroadcast(...)");
        return r3;
    }

    public static final /* synthetic */ UniversalNotificationUtils c() {
        return f;
    }

    private final void d() {
        a(new a("DEFAULT_NOTIFICATION_CHANNEL", "默认通知", "应用默认通知渠道", 0, false, false, false, false, 0, TypedValues.PositionType.TYPE_PERCENT_HEIGHT, null));
    }

    public final void a() {
        if (this.e == true) goto L6;
        this.e = true;
        d();
        return;
    }

    public final void a(NotificationContent r10) {
        Intrinsics.checkNotNullParameter(r10, Params.CONTENT);
        if (b() == true) goto L5;
        return;
    L5:
        i.a(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.b(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new UniversalNotificationUtils$showNotification$1(this, r10, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public final void a(a r6) {
        Intrinsics.checkNotNullParameter(r6, "config");
        if (this.c.getNotificationChannel(r6.a()) != null) goto L6;
        NotificationChannel r0 = new NotificationChannel(r6.a(), (CharSequence) ZeusTransformUtils.preCheckCast(r6.b(), CharSequence.class, "com.obric.memorydata.plugin"), r6.d());
        r0.setDescription(r6.c());
        r0.setShowBadge(r6.e());
        r0.enableLights(r6.f());
        r0.enableVibration(r6.g());
        r0.setBypassDnd(r6.h());
        r0.setLockscreenVisibility(r6.i());
        this.c.createNotificationChannel(r0);
        return;
    }

    public final void a(c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        if (this.d.contains(r4) == false) goto L5;
        return;
    L5:
        this.d.add(r4);
    }

    public final void a(String r16, String r17, String r18, Map<String, String> r19, int r20) {
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r19, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r16, OaidModel.KEY_ID);
        Intrinsics.checkNotNullParameter(r17, "title");
        Intrinsics.checkNotNullParameter(r18, Params.CONTENT);
        Intrinsics.checkNotNullParameter(r12, "extras");
        a();
        a(new NotificationContent(r16, r17, r18, r20, null, null, 0, false, false, false, r12, 1008, null));
    }

    public final boolean b() {
        NotificationChannel r0 = this.c.getNotificationChannel("DEFAULT_NOTIFICATION_CHANNEL");
        if (this.c.areNotificationsEnabled() == false) goto L8;
        if (r0 == null) goto L8;
        if (r0.getImportance() == 0) goto L8;
        return true;
    L8:
        return false;
    }
}
