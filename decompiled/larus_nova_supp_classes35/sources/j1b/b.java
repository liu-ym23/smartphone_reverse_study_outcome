package j1b;

import android.util.LruCache;
import com.bytedance.ee.bear.middleground.drive.export.DrivePriority;
import com.bytedance.ee.bear.middleground.drive.export.UploadRequestInfo;
import com.ss.android.lark.chameleon.AbsChameleonHandler;
import com.ss.android.lark.chameleon.Callback;
import com.ss.android.lark.chameleon.IChameleonHandlerContext;
import com.ss.android.lark.chameleon.LKAPIError;
import com.ss.android.lark.chameleon.LKAPIModules;
import com.ss.android.lark.chameleonv2.lkapi.resource.IResource$Internal$ResourceUploadRequest;
import com.ss.android.lark.chameleonv2.lkapi.resource.target.DriveResource$upload$uploadRequestInfo$1;
import com.ss.android.lark.chameleonv2.lkapi.resource.target.IMResource;
import com.ss.android.lark.officesdk.di.core.DependencyContainer;
import com.ss.android.lark.officesdk.utils.di.j;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import z0b.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b extends z0b.a {
    public static final /* synthetic */ int c = 0;
    public IMResource a;
    public com.ss.android.lark.chameleonv2.lkapi.resource.target.a b;

    public final class a extends AbsChameleonHandler<j1b.a> {
        public final String a;
        public final /* synthetic */ b b;

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final String getName() {
            return this.a;
        }

        public a(b r1) {
            this.b = r1;
            this.a = LKAPIModules.Internal.Resource.CancelUpload.getValue();
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final void handle(j1b.a r7, Callback r8) {
            j1b.a r9 = r7;
            Intrinsics.checkNotNullParameter(r9, "req");
            Intrinsics.checkNotNullParameter(r8, "callback");
            r9.getClass();
            if (Intrinsics.areEqual(null, "drive") == false) goto L16;
            com.ss.android.lark.chameleonv2.lkapi.resource.target.a r2 = this.b.b;
            if (r2 == null) goto L14;
            Intrinsics.checkNotNullParameter(r9, "req");
            Intrinsics.checkNotNullParameter(r8, "callback");
            String r10 = r2.b.get(null);
            if (r10 == null) goto L12;
            int r1 = h.a;
            Intrinsics.checkNotNullParameter(new String[]{r10}, "keys");
            DependencyContainer r0 = DependencyContainer.a;
            z0b.b r3 = (z0b.b) DependencyContainer.a(z0b.b.class, null);
            if (r3 == null) goto L11;
            r3.O();
        L11:
            j.e("LK_API_TAG_Resource", "cancel trigger success, key = " + r10 + ", uploadId =null");
        L13:
            r8.success(null);
            return;
        L12:
            j.e("LK_API_TAG_Resource", "cancel trigger failed, found no key, uploadId =null");
            goto L13
        L14:
            j.b("LK_API_TAG_Resource", "drive resource service invalid");
            r8.error(new LKAPIError(-1, "drive resource service invalid"));
            return;
        L16:
            if (this.b.a == null) goto L18;
            IMResource.b(r9, r8);
            return;
        L18:
            j.b("LK_API_TAG_Resource", "im resource service invalid");
            r8.error(new LKAPIError(-1, "im resource service invalid"));
        }
    }

    /* JADX INFO: renamed from: j1b.b$b, reason: collision with other inner class name */
    public static final class C0237b {
    }

    public final class c extends AbsChameleonHandler<IResource$Internal$ResourceUploadRequest> {
        public final String a;
        public final /* synthetic */ b b;

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final String getName() {
            return this.a;
        }

        public c(b r1) {
            this.b = r1;
            this.a = LKAPIModules.Internal.Resource.Upload.getValue();
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final void handle(IResource$Internal$ResourceUploadRequest r19, Callback r20) {
            final IResource$Internal$ResourceUploadRequest r1 = r19;
            Intrinsics.checkNotNullParameter(r1, "req");
            Intrinsics.checkNotNullParameter(r20, "callback");
            LruCache<String, String> r4 = l0b.a.a;
            String r5 = r1.getFilePath();
            Intrinsics.checkNotNullParameter(r5, "key");
            String r7 = l0b.a.a.get(r5);
            if (r7 == null) goto L17;
            b r6 = this.b;
            if (Intrinsics.areEqual(r1.getTarget(), "im") == false) goto L10;
            IMResource r2 = r6.a;
            if (r2 == null) goto L9;
            r2.d(r1, r7, r20);
            return;
        L9:
            j.b("LK_API_TAG_Resource", "im resource service invalid");
            r20.error(new LKAPIError(-1, "im resource service invalid"));
            return;
        L10:
            final com.ss.android.lark.chameleonv2.lkapi.resource.target.a r8 = r6.b;
            if (r8 == null) goto L16;
            Intrinsics.checkNotNullParameter(r1, "req");
            Intrinsics.checkNotNullParameter(r7, "uuid");
            Intrinsics.checkNotNullParameter(r20, "callback");
            DrivePriority.UploadPriority r3 = DrivePriority.UploadPriority.DEFAULT;
            r3.getPriority();
            UploadRequestInfo.UploadType r13 = UploadRequestInfo.UploadType.DRIVE;
            UploadRequestInfo r9 = new UploadRequestInfo(BuildConfig.FLAVOR, r7, r1.getFileName(), r1.getMountPointToken(), r1.getMountPoint(), BuildConfig.FLAVOR, r3.getPriority(), r13, null, null, null, new DriveResource$upload$uploadRequestInfo$1(r8, r1));
            int r10 = h.a;
            Intrinsics.checkNotNullParameter(r9, "uploadRequestInfo");
            DependencyContainer r11 = DependencyContainer.a;
            z0b.b r12 = (z0b.b) DependencyContainer.a(z0b.b.class, null);
            if (r12 == null) goto L15;
            r12.r();
        L15:
            r20.success(null);
            return;
        L16:
            j.b("LK_API_TAG_Resource", "drive resource service invalid");
            r20.error(new LKAPIError(-1, "drive resource service invalid"));
            return;
        L17:
            j.b("LK_API_TAG_Resource", "file not find");
            r20.error(new LKAPIError(-1, "file not find"));
        }
    }

    static {
    }

    @Override // z0b.a
    public final List<AbsChameleonHandler<?>> c() {
        return CollectionsKt.arrayListOf(new AbsChameleonHandler[]{new c(this), new a(this)});
    }

    public b() {
    }

    @Override // z0b.a
    public final void d(IChameleonHandlerContext r2) {
        this.a = new IMResource(r2);
        this.b = new com.ss.android.lark.chameleonv2.lkapi.resource.target.a(r2);
    }

    @Override // z0b.a
    public final void e(IChameleonHandlerContext r3) {
        IMResource r4 = this.a;
        if (r4 == null) goto L8;
        Disposable r1 = r4.b;
        if (r1 == null) goto L7;
        r1.dispose();
    L7:
        r4.b = null;
    L8:
        this.a = null;
        com.ss.android.lark.chameleonv2.lkapi.resource.target.a r5 = this.b;
        if (r5 == null) goto L11;
        r5.b.clear();
    L11:
        this.b = null;
    }
}
