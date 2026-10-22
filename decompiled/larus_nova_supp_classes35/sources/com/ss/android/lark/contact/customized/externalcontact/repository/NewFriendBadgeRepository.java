package com.ss.android.lark.contact.customized.externalcontact.repository;

import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import mtb.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class NewFriendBadgeRepository {
    public static final Lazy a = null;
    public static final a b = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/contact/customized/externalcontact/repository/NewFriendBadgeRepository$Source;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "EXTERNAL_API", "INTERNAL", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Source extends Enum<Source> {
        public static final Source EXTERNAL_API = null;
        public static final Source INTERNAL = null;
        public static final /* synthetic */ Source[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Source> getEntries() {
            return b;
        }

        static {
            Source r0 = new Source("EXTERNAL_API", 0);
            EXTERNAL_API = r0;
            Source r1 = new Source("INTERNAL", 1);
            INTERNAL = r1;
            Source[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static Source[] values() {
            return (Source[]) a.clone();
        }

        public static Source valueOf(String r1) {
            return (Source) r27.a.a(Source.class, r1);
        }

        public Source(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a implements com.ss.android.lark.contact.customized.externalcontact.repository.a {

        /* JADX INFO: renamed from: com.ss.android.lark.contact.customized.externalcontact.repository.NewFriendBadgeRepository$a$a, reason: collision with other inner class name */
        public static final class RunnableC0172a implements Runnable {
            public final /* synthetic */ k a;

            public RunnableC0172a(k r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                CopyOnWriteArrayList r0 = (CopyOnWriteArrayList) NewFriendBadgeRepository.a.getValue();     // Catch: Throwable -> L7
                k r1 = this.a;     // Catch: Throwable -> L7
                Iterator r2 = r0.iterator();     // Catch: Throwable -> L7
            L4:
                if (r2.hasNext() == false) goto L16;
                ((ltb.b) r2.next()).a(r1);     // Catch: Throwable -> L7
                goto L4
            L16:
                return;
            L7:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L11;
                return;
            L11:
                throw th;
            }
        }

        public a() {
        }

        @Override // com.ss.android.lark.contact.customized.externalcontact.repository.a
        public final void a(int r3, String r4) {
            Intrinsics.checkNotNullParameter(r4, "requestText");
            Log.i("Contact_NewFriendBadge", "onPush badge=" + r3 + " requestText=" + r4);
            k r0 = new k(r3, r4);
            Lazy r5 = NewFriendBadgeRepository.a;
            CoreThreadPool.getDefault().getUIExecutor().execute(new RunnableC0172a(r0));
        }
    }

    static {
        a = LazyKt.lazy(NewFriendBadgeRepository$listeners$2.INSTANCE);
        Intrinsics.checkNotNullParameter(BuildConfig.FLAVOR, "requestName");
        b = new a();
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.ss.android.lark.contact.customized.externalcontact.repository.NewFriendBadgeRepository$getBadge$1] */
    public static void a(Source r2, final ltb.a r3) {
        Intrinsics.checkNotNullParameter(r2, "source");
        Intrinsics.checkNotNullParameter(r3, "callback");
        Log.i("Contact_NewFriendBadge", "getBadge start source=" + r2);
        ImSdkService.d().L2(new NewFriendBadgeRepository$getBadge$1(r3));
    }
}
