package r0b;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.c;
import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.utils.rxjava.LarkRxSchedulers;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import com.suite.lark.component.protocol.Biz;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import swb.j;
import swb.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {

    /* JADX INFO: renamed from: r0b.a$a, reason: collision with other inner class name */
    public static final class C0287a<T> implements Consumer {
        public final /* synthetic */ VFSFile a;

        public C0287a(VFSFile r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            String r3 = (String) r2;
            j.h(this.a.getVfsPath());
            com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_WebResCleaner", "cleanResource, clean webapp dir success");
        }
    }

    public static final class b<T> implements Consumer {
        public static final b<T> a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r3) {
            com.ss.android.lark.officesdk.utils.di.j.c("CML_TAG_WebResCleaner", "WebResCleaner failed", (Throwable) r3);
        }
    }

    static {
    }

    public static void b() {
        VFSFile r0 = c.k().toFile();
        VFSFiles.b.getClass();
        VFSFile r1 = VFSFiles.b(true).i(r0.getAbsolutePath() + '_' + System.currentTimeMillis());
        if (r0.renameTo(r1) == false) goto L5;
        Flowable.just(BuildConfig.FLAVOR).observeOn(LarkRxSchedulers.io()).subscribe(new C0287a(r1), b.a);
        return;
    L5:
        com.ss.android.lark.officesdk.utils.di.j.f("CML_TAG_WebResCleaner", "cleanResource: rename failed ");
    }

    @JvmStatic
    public static final void a(Context r7) {
        Intrinsics.checkNotNullParameter(r7, "context");
        String r8 = n.a(r7);
        LarkKVStorage r0 = LarkKVStorage.a;
        Biz r1 = Biz.CCM;
        r0.getClass();
        String r3 = LarkKVStorage.i(r1, "app_version", false).getString("app_version_name", BuildConfig.FLAVOR);
        com.ss.android.lark.officesdk.utils.di.j.e("AppVersionHelper", "isUpgrade... savedVersion = " + r3 + ", versionName = " + r8);
        if (TextUtils.isEmpty(r3) == false) goto L5;
    L7:
        boolean r4 = false;
    L9:
        if (TextUtils.isEmpty(r8) == true) goto L11;
        LarkKVStorage.i(r1, "app_version", false).putString("app_version_name", r8);
    L11:
        com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_WebResCleaner", "cleanResource(): versionName = " + r8 + ",upgrade = " + r4);
        if (r4 == false) goto L20;
        b();     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.c("CML_TAG_WebResCleaner", "cleanResource failed ", th);
        return;
    L20:
        return;
    L5:
        if (TextUtils.equals(r3, r8) == true) goto L7;
        r4 = true;
        goto L9
    }
}
