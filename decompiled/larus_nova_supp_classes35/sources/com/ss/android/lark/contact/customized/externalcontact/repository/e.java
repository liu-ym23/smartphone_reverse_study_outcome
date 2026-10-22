package com.ss.android.lark.contact.customized.externalcontact.repository;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.contact.v2.ContactProfile;
import com.bytedance.lark.pb.contact.v2.PushDoubaoContact;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.log.Log;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e implements com.ss.android.lark.sdk.f.a {
    public static final e a = null;

    public static final class a implements com.ss.android.lark.sdk.g.b {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final void a(byte[] r4) {
            Lazy r0 = OfficeExternalContactRepository.a;
            Intrinsics.checkNotNull(r4);
            ContactProfile r5 = ((PushDoubaoContact) PushDoubaoContact.ADAPTER.decode(r4)).contact_profile;     // Catch: Exception -> L8
            if (r5 != null) goto L6;
            Log.i("Contact_ExternalContactRepository", "onPushContact ignored: empty contact_profile sid= fromPipe=false offline=false");     // Catch: Exception -> L8
        L11:
            return;
        L6:
            CoreThreadPool.getDefault().getUIExecutor().execute(new h(r5));     // Catch: Exception -> L8
        L8:
            e = move-exception;
            Log.e("Contact_ExternalContactRepository", "onPushContact error: " + e.getMessage(), e);
        }
    }

    static {
        a = new e();
    }

    public e() {
    }

    public final void a() {
        com.ss.android.lark.sdk.g.e.a.b(Command.PUSH_DOUBAO_CONTACT, a.a);
    }
}
