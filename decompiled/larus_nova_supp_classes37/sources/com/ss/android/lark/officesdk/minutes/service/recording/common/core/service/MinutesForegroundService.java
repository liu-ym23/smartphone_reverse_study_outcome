package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.MessageQueue;
import androidx.core.app.NotificationCompat;
import com.larksuite.framework.utils.a0;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSessionManager;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 )2\u00020\u0001:\u0004&'()B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\"\u0010\u0018\u001a\u00020\u00192\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0016J\u0018\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010\u001e\u001a\u00020\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010\u001f\u001a\u00020\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010 \u001a\u00020\u0017H\u0016J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\b\u001a\u00020\tH\u0002J\u0018\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/service/MinutesForegroundService;", "Landroid/app/Service;", "<init>", "()V", "isDestroying", "", "pendingNotificationContent", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/service/ForegroundNotificationContent;", "channelId", "", "shouldCreateNotificationChannel", "foregroundServiceTypes", "", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/service/MinutesForegroundService$ForegroundServiceType;", "notificationOwner", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/service/MinutesForegroundService$ForegroundServiceOwner;", "notificationTarget", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/service/MinutesForegroundService$NotificationTarget;", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "", "onStartCommand", "", "flags", "startId", "parseForegroundServiceTypes", "value", "parseNotificationOwner", "parseNotificationTarget", "onDestroy", "createNotificationChannel", "createNotification", "Landroid/app/Notification;", "title", "content", "ForegroundServiceType", "ForegroundServiceOwner", "NotificationTarget", "Companion", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MinutesForegroundService extends Service {
    public static final Companion h = null;
    public static final int i = 0;
    public static final Lazy<Handler> j = null;
    public static final LinkedHashMap<ForegroundServiceOwner, Companion.c> k = null;
    public static final Map<ForegroundServiceOwner, Long> l = null;
    public boolean a;
    public a b;
    public String c;
    public boolean d;
    public Set<? extends ForegroundServiceType> e;
    public ForegroundServiceOwner f;
    public NotificationTarget g;

    public static final class Companion {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/service/MinutesForegroundService$Companion$ForegroundAction;", "", "<init>", "(Ljava/lang/String;I)V", "START", "UPDATE", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
        public static final enum ForegroundAction extends Enum<ForegroundAction> {
            public static final ForegroundAction START = null;
            public static final ForegroundAction UPDATE = null;
            public static final /* synthetic */ ForegroundAction[] a = null;
            public static final /* synthetic */ EnumEntries b = null;

            public static EnumEntries<ForegroundAction> getEntries() {
                return b;
            }

            static {
                ForegroundAction r0 = new ForegroundAction("START", 0);
                START = r0;
                ForegroundAction r1 = new ForegroundAction("UPDATE", 1);
                UPDATE = r1;
                ForegroundAction[] r3 = {r0, r1};
                a = r3;
                b = EnumEntriesKt.enumEntries(r3);
            }

            public static ForegroundAction[] values() {
                return (ForegroundAction[]) a.clone();
            }

            public static ForegroundAction valueOf(String r1) {
                return (ForegroundAction) r27.a.a(ForegroundAction.class, r1);
            }

            public ForegroundAction(String r1, int r2) {
                super(r1, r2);
            }
        }

        public static final class a {
            public final Set<ForegroundServiceOwner> a;
            public final Set<ForegroundServiceType> b;
            public final ForegroundServiceOwner c;
            public final String d;
            public final String e;
            public final b f;
            public final NotificationTarget g;

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof a) == true) goto L8;
                return false;
            L8:
                a r6 = (a) r5;
                if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
                return false;
            L15:
                if (this.c == r6.c) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
                return false;
            L21:
                if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
                return false;
            L24:
                if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
                return false;
            L27:
                if (this.g == r6.g) goto L29;
                return false;
            L29:
                return true;
            }

            public final int hashCode() {
                int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
                String r1 = this.d;
                int r2 = 0;
                if (r1 != null) goto L5;
                int r3 = 0;
            L6:
                int r4 = (r0 + r3) * 31;
                String r5 = this.e;
                if (r5 == null) goto L11;
                r2 = r5.hashCode();
            L11:
                return ((((r4 + r2) * 31) + this.f.hashCode()) * 31) + this.g.hashCode();
            L5:
                r3 = r1.hashCode();
                goto L6
            }

            public final String toString() {
                return "ForegroundSnapshot(owners=" + this.a + ", types=" + this.b + ", notificationOwner=" + this.c + ", title=" + this.d + ", content=" + this.e + ", channelConfig=" + this.f + ", notificationTarget=" + this.g + ')';
            }

            /* JADX WARN: Multi-variable type inference failed */
            public a(Set<? extends ForegroundServiceOwner> r2, Set<? extends ForegroundServiceType> r3, ForegroundServiceOwner r4, String r5, String r6, b r7, NotificationTarget r8) {
                Intrinsics.checkNotNullParameter(r2, "owners");
                Intrinsics.checkNotNullParameter(r3, "types");
                Intrinsics.checkNotNullParameter(r4, "notificationOwner");
                Intrinsics.checkNotNullParameter(r7, "channelConfig");
                Intrinsics.checkNotNullParameter(r8, "notificationTarget");
                this.a = r2;
                this.b = r3;
                this.c = r4;
                this.d = r5;
                this.e = r6;
                this.f = r7;
                this.g = r8;
            }
        }

        public static final class b {
            public final String a;
            public final boolean b;

            public b() {
                this(0);
            }

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof b) == true) goto L8;
                return false;
            L8:
                b r6 = (b) r5;
                if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
                return false;
            L12:
                if (this.b == r6.b) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                int r0 = this.a.hashCode() * 31;
                if (this.b == false) goto L5;
                int r1 = 1231;
            L7:
                return r0 + r1;
            L5:
                r1 = 1237;
                goto L7
            }

            public final String toString() {
                return "NotificationChannelConfig(channelId=" + this.a + ", shouldCreateChannel=" + this.b + ')';
            }

            public /* synthetic */ b(int r2) {
                this("MinutesAudioRecordingChannel", true);
            }

            public b(String r2, boolean r3) {
                Intrinsics.checkNotNullParameter(r2, "channelId");
                this.a = r2;
                this.b = r3;
            }
        }

        public static final class c {
            public final ForegroundServiceType a;
            public final String b;
            public final String c;
            public final b d;
            public final NotificationTarget e;

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof c) == true) goto L8;
                return false;
            L8:
                c r6 = (c) r5;
                if (this.a == r6.a) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
                return false;
            L21:
                if (this.e == r6.e) goto L23;
                return false;
            L23:
                return true;
            }

            public final int hashCode() {
                int r0 = this.a.hashCode() * 31;
                String r1 = this.b;
                int r2 = 0;
                if (r1 != null) goto L5;
                int r3 = 0;
            L6:
                int r4 = (r0 + r3) * 31;
                String r5 = this.c;
                if (r5 == null) goto L11;
                r2 = r5.hashCode();
            L11:
                return ((((r4 + r2) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
            L5:
                r3 = r1.hashCode();
                goto L6
            }

            public final String toString() {
                return "OwnerState(type=" + this.a + ", title=" + this.b + ", content=" + this.c + ", channelConfig=" + this.d + ", notificationTarget=" + this.e + ')';
            }

            public final ForegroundServiceType getType() {
                return this.a;
            }

            public c(ForegroundServiceType r2, String r3, String r4, b r5, NotificationTarget r6) {
                Intrinsics.checkNotNullParameter(r2, "type");
                Intrinsics.checkNotNullParameter(r5, "channelConfig");
                Intrinsics.checkNotNullParameter(r6, "notificationTarget");
                this.a = r2;
                this.b = r3;
                this.c = r4;
                this.d = r5;
                this.e = r6;
            }
        }

        public /* synthetic */ class d {
            public static final /* synthetic */ int[] a = null;
            public static final /* synthetic */ int[] b = null;

            static {
                int[] r0 = new int[ForegroundServiceType.values().length];
                r0[ForegroundServiceType.HARDWARE_LIVE_RECORDING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
            L24:
                r0[ForegroundServiceType.RECORDING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
            L30:
                r0[ForegroundServiceType.DATA_SYNC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
            L8:
                a = r0;
                int[] r1 = new int[ForegroundServiceOwner.values().length];
                r1[ForegroundServiceOwner.HARDWARE_FILE_SYNC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
            L26:
                r1[ForegroundServiceOwner.FILE_UPLOAD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
            L32:
                r1[ForegroundServiceOwner.RECORDING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
            L22:
                r1[ForegroundServiceOwner.HARDWARE_LIVE_RECORDING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L21
            L13:
                b = r1;
            }
        }

        public static final class e implements MessageQueue.IdleHandler {
            public final /* synthetic */ Ref.BooleanRef a;
            public final /* synthetic */ Runnable b;
            public final /* synthetic */ Function0<Unit> c;

            public e(Ref.BooleanRef r1, f r2, Function0 r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            @Override // android.os.MessageQueue.IdleHandler
            public final boolean queueIdle() {
                Ref.BooleanRef r0 = this.a;
                if (r0.element == false) goto L5;
                return false;
            L5:
                r0.element = true;
                Companion r1 = MinutesForegroundService.h;
                ((Handler) MinutesForegroundService.j.getValue()).removeCallbacks(this.b);
                this.c.invoke();
                return false;
            }
        }

        public static final class f implements Runnable {
            public final /* synthetic */ Ref.BooleanRef a;
            public final /* synthetic */ Function0<Unit> b;

            public f(Ref.BooleanRef r1, Function0<Unit> r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Ref.BooleanRef r0 = this.a;     // Catch: Throwable -> L7
                if (r0.element == true) goto L10;
                r0.element = true;     // Catch: Throwable -> L7
                this.b.invoke();     // Catch: Throwable -> L7
                return;
            L10:
                return;
            L7:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L14;
                throw th;
            }
        }

        public static a b() {
            LinkedHashMap<ForegroundServiceOwner, c> r0 = MinutesForegroundService.k;
            Object r2 = null;
            if (r0.isEmpty() == false) goto L5;
            return null;
        L5:
            Set<ForegroundServiceOwner> r1 = r0.keySet();
            LinkedHashMap r3 = new LinkedHashMap();
            Iterator<Map.Entry<ForegroundServiceOwner, c>> r4 = r0.entrySet().iterator();
        L6:
            boolean r6 = true;
            if (r4.hasNext() == false) goto L28;
            Map.Entry<ForegroundServiceOwner, c> r5 = r4.next();
            c r8 = r5.getValue();
            String r9 = r8.b;
            if (r9 != null) goto L11;
        L14:
            boolean r10 = true;
        L15:
            if (r10 == false) goto L26;
            String r11 = r8.c;
            if (r11 != null) goto L19;
        L22:
            boolean r12 = true;
        L23:
            if (r12 == false) goto L26;
            r6 = false;
            goto L26
        L19:
            if (r11.length() == 0) goto L22;
            r12 = false;
        L26:
            if (r6 == false) goto L6;
            r3.put(r5.getKey(), r5.getValue());
            goto L6
        L11:
            if (r9.length() == 0) goto L14;
            r10 = false;
            goto L15
        L28:
            Set r7 = r3.keySet();
            Intrinsics.checkNotNullParameter(r1, "owners");
            Intrinsics.checkNotNullParameter(r7, "ownersWithContent");
            List r13 = CollectionsKt.listOf(new ForegroundServiceOwner[]{ForegroundServiceOwner.RECORDING, ForegroundServiceOwner.HARDWARE_LIVE_RECORDING, ForegroundServiceOwner.HARDWARE_FILE_SYNC, ForegroundServiceOwner.FILE_UPLOAD});
            Iterator r14 = r13.iterator();
        L30:
            if (r14.hasNext() == false) goto L34;
            Object r15 = r14.next();
            if (r7.contains((ForegroundServiceOwner) r15) == false) goto L30;
            r2 = r15;
        L34:
            ForegroundServiceOwner r16 = (ForegroundServiceOwner) r2;
            if (r16 != null) goto L44;
            Iterator r17 = r13.iterator();
        L38:
            if (r17.hasNext() == false) goto L43;
            ForegroundServiceOwner r18 = (ForegroundServiceOwner) r17.next();
            if (r1.contains(r18) == false) goto L38;
            r16 = r18;
            goto L44
        L43:
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        L44:
            Iterator<T> r19 = r0.entrySet().iterator();
        L46:
            if (r19.hasNext() == false) goto L59;
            Map.Entry r20 = (Map.Entry) r19.next();
            if (r20.getKey() != r16) goto L50;
            boolean r21 = true;
        L51:
            if (r21 == false) goto L46;
            LinkedHashMap<ForegroundServiceOwner, c> r22 = MinutesForegroundService.k;
            Set r23 = CollectionsKt.toSet(r22.keySet());
            Collection<c> r24 = r22.values();
            LinkedHashSet r25 = new LinkedHashSet();
            Iterator<T> r26 = r24.iterator();
        L54:
            if (r26.hasNext() == false) goto L57;
            r25.add(((c) r26.next()).getType());
            goto L54
        L57:
            return new a(r23, r25, (ForegroundServiceOwner) r20.getKey(), ((c) r20.getValue()).b, ((c) r20.getValue()).c, ((c) r20.getValue()).d, ((c) r20.getValue()).e);
        L50:
            r21 = false;
            goto L51
        L59:
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }

        public Companion() {
        }

        public static final b a(MmRecordingSessionManager r4) {
            Companion r0 = MinutesForegroundService.h;
            int r1 = 0;
            Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L21
            kub.f r5 = (kub.f) r4.a.u(kub.f.class);     // Catch: Throwable -> L21
            boolean r3 = true;
            if (r5 == null) goto L10;
            String r6 = r5.E();     // Catch: Throwable -> L21
            if (r6 == null) goto L10;
            if ((!StringsKt.isBlank(r6)) == false) goto L10;
        L11:
            if (r6 != null) goto L13;
        L16:
            if (r3 == false) goto L18;
            b r7 = new b(r1);     // Catch: Throwable -> L21
        L19:
            Object r8 = Result.constructor-impl(r7);     // Catch: Throwable -> L21
        L23:
            Throwable r9 = Result.exceptionOrNull-impl(r8);
            if (r9 == null) goto L28;
            lvb.a.b("MinutesForegroundService", "resolve channel config failed, error:" + r9);
            r8 = new b(r1);
        L28:
            return (b) r8;
        L18:
            r7 = new b(r6, r5.y());     // Catch: Throwable -> L21
            goto L19
        L13:
            if (StringsKt.isBlank(r6) == true) goto L16;
            r3 = false;
        L10:
            r6 = null;
        L21:
            th = move-exception;
            Result.Companion r10 = Result.Companion;
            r8 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L23
        }

        public static NotificationTarget c(ForegroundServiceOwner r1) {
            int r2 = d.b[r1.ordinal()];
            if (r2 == 1) goto L15;
            if (r2 == 2) goto L15;
            if (r2 == 3) goto L16;
            if (r2 == 4) goto L16;
            throw new NoWhenBranchMatchedException();
        L16:
            return NotificationTarget.RECORDING;
        L15:
            return NotificationTarget.D1204_DEVICE;
        }

        public static ForegroundServiceOwner d(ForegroundServiceType r1) {
            int r2 = d.a[r1.ordinal()];
            if (r2 == 1) goto L13;
            if (r2 == 2) goto L14;
            if (r2 == 3) goto L14;
            throw new NoWhenBranchMatchedException();
        L14:
            return ForegroundServiceOwner.RECORDING;
        L13:
            return ForegroundServiceOwner.HARDWARE_LIVE_RECORDING;
        }

        public static void e(Function0 r5) {
            Ref.BooleanRef r0 = new Ref.BooleanRef();
            f r1 = new f(r0, r5);
            ((Handler) MinutesForegroundService.j.getValue()).postDelayed(r1, 3000);
            Looper.myQueue().addIdleHandler(new e(r0, r1, r5));
        }

        public static void j(Context r6, ForegroundServiceOwner r7) {
            Intrinsics.checkNotNullParameter(r6, "context");
            Intrinsics.checkNotNullParameter(r7, "owner");
            LinkedHashMap<ForegroundServiceOwner, c> r0 = MinutesForegroundService.k;
            monitor-enter(r0);
            Map<ForegroundServiceOwner, Long> r1 = MinutesForegroundService.l;     // Catch: Throwable -> L34
            Long r2 = (Long) ((LinkedHashMap) r1).get(r7);     // Catch: Throwable -> L34
            if (r2 == null) goto L7;
            long r3 = r2.longValue();     // Catch: Throwable -> L34
        L8:
            r1.put(r7, Long.valueOf(r3 + 1));     // Catch: Throwable -> L34
            if (r0.remove(r7) == null) goto L11;
            boolean r4 = true;
        L12:
            Boolean r5 = Boolean.valueOf(r4);     // Catch: Throwable -> L34
            Companion r8 = MinutesForegroundService.h;     // Catch: Throwable -> L34
            Pair r9 = TuplesKt.to(r5, b());     // Catch: Throwable -> L34
            monitor-exit(r0);
            boolean r10 = ((Boolean) r9.component1()).booleanValue();
            a r11 = (a) r9.component2();
            if (r10 == true) goto L18;
            lvb.a.e("MinutesForegroundService", "skip stop foreground service because owner is not active, owner=" + r7);
            return;
        L18:
            StringBuilder r12 = new StringBuilder("stop foreground service owner=");
            r12.append(r7);
            r12.append(", remainingOwners=");
            if (r11 == null) goto L21;
            Set<ForegroundServiceOwner> r13 = r11.a;
        L22:
            r12.append(r13);
            lvb.a.e("MinutesForegroundService", r12.toString());
            if (r11 == null) goto L39;
            i(r6, ForegroundAction.UPDATE, r11);
            return;
        L39:
            Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L26
            Object r15 = Result.constructor-impl(Boolean.valueOf(r6.stopService(new Intent(r6, MinutesForegroundService.class))));     // Catch: Throwable -> L26
        L28:
            Throwable r16 = Result.exceptionOrNull-impl(r15);
            if (r16 == null) goto L31;
            lvb.a.b("MinutesForegroundService", "stop service failed:" + r16);
        L31:
            Result.box-impl(r15);
            return;
        L26:
            th = move-exception;
            Result.Companion r17 = Result.Companion;
            r15 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L28
        L21:
            r13 = null;
            goto L22
        L11:
            r4 = false;
            goto L12
        L7:
            r3 = 0;
        L34:
            th = move-exception;
            throw th;
        }

        public static void i(Context r11, ForegroundAction r12, a r13) {
            Intent r0 = new Intent(r11, MinutesForegroundService.class);
            r0.putExtra("extra_action", r12.name());
            r0.putExtra("extra_title", r13.d);
            r0.putExtra("extra_content", r13.e);
            r0.putExtra("extra_channel_id", r13.f.a);
            r0.putExtra("extra_should_create_channel", r13.f.b);
            r0.putExtra("extra_foreground_service_types", CollectionsKt.joinToString$default(r13.b, fyb.a.COMMA, null, null, 0, null, MinutesForegroundService$Companion$startServiceInternal$intent$1$1.INSTANCE, 30, null));
            r0.putExtra("extra_notification_owner", r13.c.name());
            r0.putExtra("extra_notification_target", r13.g.name());
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
            if (Build.VERSION.SDK_INT < 26) goto L6;
            ComponentName r14 = r11.startForegroundService(r0);     // Catch: Throwable -> L9
        L7:
            Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L9
        L11:
            Throwable r16 = Result.exceptionOrNull-impl(r15);
            if (r16 == null) goto L17;
            lvb.a.b("MinutesForegroundService", "start service failed, action=" + r12 + ", owners=" + r13.a + ", serviceTypes=" + r13.b + ", error:" + r16);
            return;
        L17:
            return;
        L6:
            r14 = r11.startService(r0);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            Result.Companion r2 = Result.Companion;
            r15 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L11
        }

        public static /* synthetic */ void k(Context r8, String r9, String r10, MmRecordingSessionManager r11, ForegroundServiceType r12, int r13) {
            Companion r0 = MinutesForegroundService.h;
            if ((r13 & 16) == 0) goto L5;
            r12 = ForegroundServiceType.RECORDING;
        L5:
            ForegroundServiceType r5 = r12;
            if ((r13 & 32) == 0) goto L8;
            ForegroundServiceOwner r6 = d(r5);
        L10:
            if ((r13 & 64) == 0) goto L12;
            NotificationTarget r7 = c(r6);
        L13:
            r0.update(r8, r9, r10, r11, r5, r6, r7);
            return;
        L12:
            r7 = null;
            goto L13
        L8:
            r6 = null;
            goto L10
        }

        public static /* synthetic */ void h(Context r8, MmRecordingSessionManager r9, ForegroundServiceType r10, String r11, String r12, boolean r13, int r14) {
            if ((r14 & 4) == 0) goto L5;
            r10 = ForegroundServiceType.RECORDING;
        L5:
            ForegroundServiceType r2 = r10;
            if ((r14 & 8) == 0) goto L8;
            ForegroundServiceOwner r3 = d(r2);
        L10:
            if ((r14 & 16) == 0) goto L12;
            String r4 = null;
        L14:
            if ((r14 & 32) == 0) goto L16;
            String r5 = null;
        L18:
            if ((r14 & 64) == 0) goto L20;
            NotificationTarget r6 = c(r3);
        L22:
            if ((r14 & 128) == 0) goto L24;
            boolean r7 = false;
        L25:
            g(r8, r9, r2, r3, r4, r5, r6, r7);
            return;
        L24:
            r7 = r13;
            goto L25
        L20:
            r6 = null;
            goto L22
        L16:
            r5 = r12;
            goto L18
        L12:
            r4 = r11;
            goto L14
        L8:
            r3 = null;
            goto L10
        }

        public final void update(Context r11, String r12, String r13, MmRecordingSessionManager r14, ForegroundServiceType r15, ForegroundServiceOwner r16, NotificationTarget r17) {
            Intrinsics.checkNotNullParameter(r11, "context");
            Intrinsics.checkNotNullParameter(r12, "title");
            Intrinsics.checkNotNullParameter(r13, "content");
            Intrinsics.checkNotNullParameter(r14, "sessionManager");
            Intrinsics.checkNotNullParameter(r15, "foregroundServiceType");
            Intrinsics.checkNotNullParameter(r16, "owner");
            Intrinsics.checkNotNullParameter(r17, "notificationTarget");
            lvb.a.e("MinutesForegroundService", "update foreground service, serviceType=" + r15);
            f(r11, ForegroundAction.UPDATE, r14, r15, r16, r12, r13, r17, false);
        }

        public static void g(Context r9, MmRecordingSessionManager r10, ForegroundServiceType r11, ForegroundServiceOwner r12, String r13, String r14, NotificationTarget r15, boolean r16) {
            Intrinsics.checkNotNullParameter(r9, "context");
            Intrinsics.checkNotNullParameter(r10, "sessionManager");
            Intrinsics.checkNotNullParameter(r11, "foregroundServiceType");
            Intrinsics.checkNotNullParameter(r12, "owner");
            Intrinsics.checkNotNullParameter(r15, "notificationTarget");
            lvb.a.e("MinutesForegroundService", "start foreground service, owner=" + r12 + ", serviceType=" + r11 + ", dispatchImmediately=" + r16);
            f(r9, ForegroundAction.START, r10, r11, r12, r13, r14, r15, r16);
        }

        public static void f(final Context r13, final ForegroundAction r14, final MmRecordingSessionManager r15, final ForegroundServiceType r16, final ForegroundServiceOwner r17, final String r18, final String r19, final NotificationTarget r20, boolean r21) {
            lvb.a.e("MinutesForegroundService", "sendAction action=" + r14 + ", owner=" + r17 + ", serviceType=" + r16);
            LinkedHashMap<ForegroundServiceOwner, c> r1 = MinutesForegroundService.k;
            monitor-enter(r1);
            Map<ForegroundServiceOwner, Long> r2 = MinutesForegroundService.l;     // Catch: Throwable -> L18
            Long r3 = (Long) ((LinkedHashMap) r2).get(r17);     // Catch: Throwable -> L18
            if (r3 == null) goto L7;
            long r5 = r3.longValue();     // Catch: Throwable -> L18
        L8:
            final long r6 = r5 + 1;     // Catch: Throwable -> L18
            r2.put(r17, Long.valueOf(r6));     // Catch: Throwable -> L18
            monitor-exit(r1);
            Function0<Unit> r12 = new MinutesForegroundService$Companion$sendAction$task$1(r6, r14, r17, r15, r13, r16, r18, r19, r20);
            if (r21 == false) goto L14;
            r12.invoke();
            return;
        L14:
            if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L16;
            e(r12);
            return;
        L16:
            ((Handler) MinutesForegroundService.j.getValue()).post(new com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.b(r12));
            return;
        L7:
            r5 = 0;
        L18:
            th = move-exception;
            throw th;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/service/MinutesForegroundService$ForegroundServiceOwner;", "", "<init>", "(Ljava/lang/String;I)V", "RECORDING", "HARDWARE_LIVE_RECORDING", "HARDWARE_FILE_SYNC", "FILE_UPLOAD", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final enum ForegroundServiceOwner extends Enum<ForegroundServiceOwner> {
        public static final ForegroundServiceOwner FILE_UPLOAD = null;
        public static final ForegroundServiceOwner HARDWARE_FILE_SYNC = null;
        public static final ForegroundServiceOwner HARDWARE_LIVE_RECORDING = null;
        public static final ForegroundServiceOwner RECORDING = null;
        public static final /* synthetic */ ForegroundServiceOwner[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<ForegroundServiceOwner> getEntries() {
            return b;
        }

        static {
            ForegroundServiceOwner r0 = new ForegroundServiceOwner("RECORDING", 0);
            RECORDING = r0;
            ForegroundServiceOwner r1 = new ForegroundServiceOwner("HARDWARE_LIVE_RECORDING", 1);
            HARDWARE_LIVE_RECORDING = r1;
            ForegroundServiceOwner r3 = new ForegroundServiceOwner("HARDWARE_FILE_SYNC", 2);
            HARDWARE_FILE_SYNC = r3;
            ForegroundServiceOwner r5 = new ForegroundServiceOwner("FILE_UPLOAD", 3);
            FILE_UPLOAD = r5;
            ForegroundServiceOwner[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
        }

        public static ForegroundServiceOwner[] values() {
            return (ForegroundServiceOwner[]) a.clone();
        }

        public static ForegroundServiceOwner valueOf(String r1) {
            return (ForegroundServiceOwner) r27.a.a(ForegroundServiceOwner.class, r1);
        }

        public ForegroundServiceOwner(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/service/MinutesForegroundService$ForegroundServiceType;", "", "<init>", "(Ljava/lang/String;I)V", "RECORDING", "HARDWARE_LIVE_RECORDING", "DATA_SYNC", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final enum ForegroundServiceType extends Enum<ForegroundServiceType> {
        public static final ForegroundServiceType DATA_SYNC = null;
        public static final ForegroundServiceType HARDWARE_LIVE_RECORDING = null;
        public static final ForegroundServiceType RECORDING = null;
        public static final /* synthetic */ ForegroundServiceType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<ForegroundServiceType> getEntries() {
            return b;
        }

        static {
            ForegroundServiceType r0 = new ForegroundServiceType("RECORDING", 0);
            RECORDING = r0;
            ForegroundServiceType r1 = new ForegroundServiceType("HARDWARE_LIVE_RECORDING", 1);
            HARDWARE_LIVE_RECORDING = r1;
            ForegroundServiceType r3 = new ForegroundServiceType("DATA_SYNC", 2);
            DATA_SYNC = r3;
            ForegroundServiceType[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static ForegroundServiceType[] values() {
            return (ForegroundServiceType[]) a.clone();
        }

        public static ForegroundServiceType valueOf(String r1) {
            return (ForegroundServiceType) r27.a.a(ForegroundServiceType.class, r1);
        }

        public ForegroundServiceType(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/service/MinutesForegroundService$NotificationTarget;", "", "<init>", "(Ljava/lang/String;I)V", "RECORDING", "D1204_DEVICE", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final enum NotificationTarget extends Enum<NotificationTarget> {
        public static final NotificationTarget D1204_DEVICE = null;
        public static final NotificationTarget RECORDING = null;
        public static final /* synthetic */ NotificationTarget[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<NotificationTarget> getEntries() {
            return b;
        }

        static {
            NotificationTarget r0 = new NotificationTarget("RECORDING", 0);
            RECORDING = r0;
            NotificationTarget r1 = new NotificationTarget("D1204_DEVICE", 1);
            D1204_DEVICE = r1;
            NotificationTarget[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static NotificationTarget[] values() {
            return (NotificationTarget[]) a.clone();
        }

        public static NotificationTarget valueOf(String r1) {
            return (NotificationTarget) r27.a.a(NotificationTarget.class, r1);
        }

        public NotificationTarget(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent r1) {
        return null;
    }

    @Override // android.app.Service
    public final void onDestroy() {
        this.a = true;
        lvb.a.e("MinutesForegroundService", "onDestroy: Service stopped");
        if (Build.VERSION.SDK_INT < 24) goto L5;
        stopForeground(1);
    L6:
        Object r0 = getSystemService("notification");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) r0).cancel(i);
        super.onDestroy();
        return;
    L5:
        stopForeground(true);
        goto L6
    }

    static {
        h = new Companion();
        i = a0.a(1);
        j = LazyKt.lazy(MinutesForegroundService$Companion$mainHandler$2.INSTANCE);
        k = new LinkedHashMap();
        l = new LinkedHashMap();
    }

    public MinutesForegroundService() {
        this.b = new a(null, null);
        this.c = "MinutesAudioRecordingChannel";
        this.d = true;
        this.e = SetsKt.setOf(ForegroundServiceType.RECORDING);
        this.f = ForegroundServiceOwner.RECORDING;
        this.g = NotificationTarget.RECORDING;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        lvb.a.e("MinutesForegroundService", "onCreate: Service started");
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent r21, int r22, int r23) {
        lvb.a.e("MinutesForegroundService", "onStartCommand, isDestroying=" + this.a);
        if (this.a == false) goto L6;
        lvb.a.h("MinutesForegroundService", "onStartCommand: ignoring, service is destroying");
        return 2;
    L6:
        if (r21 == null) goto L8;
        String r5 = r21.getStringExtra("extra_action");
    L9:
        String r8 = "";
        int r9 = 0;
        if (r21 == null) goto L58;
        String r11 = r21.getStringExtra("extra_title");
        String r12 = r21.getStringExtra("extra_content");
        String r13 = r21.getStringExtra("extra_channel_id");
        if (r13 != null) goto L14;
    L18:
        r13 = "MinutesAudioRecordingChannel";
    L19:
        this.c = r13;
        this.d = r21.getBooleanExtra("extra_should_create_channel", true);
        String r14 = r21.getStringExtra("extra_foreground_service_types");
        if (r14 != null) goto L22;
        String r15 = "";
    L23:
        List r16 = StringsKt.split$default(r15, new char[]{','}, false, 0, 6, null);
        LinkedHashSet r17 = new LinkedHashSet();
        Iterator r18 = r16.iterator();
    L25:
        if (r18.hasNext() == false) goto L37;
        String r19 = (String) r18.next();
        ForegroundServiceType[] r2 = ForegroundServiceType.values();
        int r4 = r2.length;
    L27:
        if (r9 >= r4) goto L32;
        ForegroundServiceType r110 = r2[r9];
        if (Intrinsics.areEqual(r110.name(), r19) == true) goto L30;
        r9 = r9 + 1;
        goto L27
    L30:
        ForegroundServiceType r3 = r110;
    L33:
        if (r3 == null) goto L35;
        r17.add(r3);
    L35:
        r9 = 0;
        goto L25
    L32:
        r3 = null;
        goto L33
    L37:
        if (r17.isEmpty() == false) goto L39;
        r17 = SetsKt.linkedSetOf(new ForegroundServiceType[]{ForegroundServiceType.RECORDING});
    L39:
        this.e = r17;
        String r6 = r21.getStringExtra("extra_notification_owner");
        ForegroundServiceOwner[] r7 = ForegroundServiceOwner.values();
        int r10 = r7.length;
        int r111 = 0;
    L40:
        if (r111 >= r10) goto L45;
        ForegroundServiceOwner r112 = r7[r111];
        if (Intrinsics.areEqual(r112.name(), r6) == true) goto L46;
        r111 = r111 + 1;
    L46:
        if (r112 != null) goto L48;
        r112 = ForegroundServiceOwner.RECORDING;
    L48:
        this.f = r112;
        String r0 = r21.getStringExtra("extra_notification_target");
        NotificationTarget[] r20 = NotificationTarget.values();
        int r24 = r20.length;
        int r25 = 0;
    L49:
        if (r25 >= r24) goto L54;
        NotificationTarget r113 = r20[r25];
        if (Intrinsics.areEqual(r113.name(), r0) == true) goto L52;
        r25 = r25 + 1;
        goto L49
    L52:
        NotificationTarget r26 = r113;
    L55:
        if (r26 != null) goto L57;
        r26 = NotificationTarget.RECORDING;
    L57:
        this.g = r26;
        a r27 = new a(r11, r12);
    L59:
        a r1 = this.b;
        Intrinsics.checkNotNullParameter(r1, "current");
        if (r27 != null) goto L62;
        r27 = r1;
    L62:
        this.b = r27;
        lvb.a.e("MinutesForegroundService", "handle action=" + r5 + ", serviceTypes=" + this.e + ", notificationOwner=" + this.f + ", title=" + this.b.a + ", content=" + this.b.b + ", channelId=" + this.c + ", shouldCreateChannel=" + this.d);
        a r28 = this.b;
        String r29 = r28.a;
        if (r29 != null) goto L65;
        r29 = "";
    L65:
        String r30 = r28.b;
        if (r30 == null) goto L70;
        r8 = r30;
    L70:
        if (this.d == false) goto L74;
        String r31 = this.c;
        if (Build.VERSION.SDK_INT < 26) goto L74;
        ((NotificationManager) getSystemService(NotificationManager.class)).createNotificationChannel(new NotificationChannel(r31, "Audio Recording Service", 2));
    L74:
        Intent r32 = new Intent(this, MinutesForegroundRouterActivity.class);
        r32.addFlags(335544320);
        r32.putExtra("extra_notification_owner", this.f.name());
        r32.putExtra("extra_notification_target", this.g.name());
        int r33 = 0;
        PendingIntent r34 = PendingIntent.getActivity(this, 0, r32, 201326592);
        NotificationCompat.Builder r35 = new NotificationCompat.Builder(this, this.c).setContentTitle(r29).setContentText(r8).setPriority(0).setSilent(true).setShowWhen(false).setOnlyAlertOnce(true);
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isLarkApp() == false) goto L77;
        int r36 = 2131236062;
    L78:
        Notification r37 = r35.setSmallIcon(r36).setContentIntent(r34).build();
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L101
        if (Build.VERSION.SDK_INT < 34) goto L98;
        Set<? extends ForegroundServiceType> r39 = this.e;     // Catch: Throwable -> L101
        Intrinsics.checkNotNullParameter(r39, "types");     // Catch: Throwable -> L101
        Iterator<T> r40 = r39.iterator();     // Catch: Throwable -> L101
    L84:
        if (r40.hasNext() == false) goto L97;
        int r41 = c.a[((ForegroundServiceType) r40.next()).ordinal()];     // Catch: Throwable -> L101
        if (r41 != 1) goto L88;
        int r42 = 144;
    L96:
        r33 = r33 | r42;     // Catch: Throwable -> L101
        goto L84
    L88:
        if (r41 != 2) goto L90;
        r42 = 16;
        goto L96
    L90:
        if (r41 != 3) goto L93;
        r42 = 1;
        goto L96
    L93:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L101
    L97:
        startForeground(i, r37, r33);     // Catch: Throwable -> L101
        lvb.a.e("MinutesForegroundService", "startForeground success, action=" + r5 + ", serviceTypes=" + this.e + ", foregroundServiceType=" + r33);     // Catch: Throwable -> L101
    L99:
        Object r43 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L101
    L103:
        Throwable r44 = Result.exceptionOrNull-impl(r43);
        if (r44 == null) goto L123;
        lvb.a.b("MinutesForegroundService", "startForeground failed, action=" + r5 + ", serviceTypes=" + this.e + ", channelId=" + this.c + ", error:" + r44);
        stopSelf(r23);
        return 2;
    L123:
        return 2;
    L98:
        startForeground(i, r37);     // Catch: Throwable -> L101
        lvb.a.e("MinutesForegroundService", "startForeground success, action=" + r5 + ", serviceTypes=" + this.e);     // Catch: Throwable -> L101
    L101:
        th = move-exception;
        Result.Companion r45 = Result.Companion;
        r43 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L103
    L77:
        r36 = 2131244768;
        goto L78
    L54:
        r26 = null;
        goto L55
    L45:
        r112 = null;
        goto L46
    L22:
        r15 = r14;
        goto L23
    L14:
        if (Boolean.valueOf(!StringsKt.isBlank(r13)).booleanValue() == true) goto L17;
        r13 = null;
    L17:
        if (r13 != null) goto L19;
    L58:
        r27 = null;
        goto L59
    L8:
        r5 = null;
        goto L9
    }
}
