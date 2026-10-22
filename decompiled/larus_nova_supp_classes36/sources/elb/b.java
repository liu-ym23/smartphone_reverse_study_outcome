package elb;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.appreciablelib.AppreciableKit;
import com.ss.android.lark.image.uploader.entity.ImageUploadTask;
import com.ss.android.lark.image.uploader.upload.ImageUploadManager$batchUpload$1;
import com.ss.android.lark.image.uploader.upload.ImageUploadManager$wrapUploader$1;
import com.ss.android.lark.image.uploader.upload.e;
import com.ss.android.lark.image.uploader.upload.f;
import com.ss.android.lark.image.uploader.upload.g;
import com.ss.android.lark.image.uploader.upload.h;
import com.ss.android.lark.utils.rxjava.LarkRxSchedulers;
import hlb.d;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public static final ExecutorService a = null;

    public static final class a<T, R> implements Function {
        public final /* synthetic */ ImageUploadTask a;

        public a(ImageUploadTask r1) {
            this.a = r1;
        }

        public final Object apply(Object r3) {
            com.ss.android.lark.image.uploader.entity.b r4 = (com.ss.android.lark.image.uploader.entity.b) r3;
            Intrinsics.checkNotNullParameter(r4, "uploadImage");
            if (r4.n != null) goto L7;
            glb.b.a.getClass();
            glb.b.d(r4);
            glb.a r0 = r4.n;
            if (r0 == null) goto L7;
            r0.o = true;
        L7:
            ExecutorService r1 = b.a;
            return Observable.create(new c(r4, this.a));
        }
    }

    /* JADX INFO: renamed from: elb.b$b, reason: collision with other inner class name */
    public static final class C0253b<T, R> implements Function {
        public final /* synthetic */ Ref.BooleanRef a;
        public final /* synthetic */ ImageUploadTask b;
        public final /* synthetic */ e c;

        public C0253b(Ref.BooleanRef r1, ImageUploadTask r2, e r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final Object apply(Object r5) {
            com.ss.android.lark.image.uploader.entity.b r6 = (com.ss.android.lark.image.uploader.entity.b) r5;
            Intrinsics.checkNotNullParameter(r6, "uploadImage");
            if (this.a.element == true) goto L11;
            dlb.a r1 = this.b.f;
            if (r1 == null) goto L7;
            r1.c();
        L7:
            dlb.a r2 = this.b.f;
            if (r2 == null) goto L10;
            r2.g();
        L10:
            this.a.element = true;
        L11:
            glb.a r3 = r6.n;
            if (r3 != null) goto L14;
        L20:
            int r4 = h.a;
            e r7 = this.c;
            Intrinsics.checkNotNullParameter(r6, "uploadImage");
            Intrinsics.checkNotNullParameter(r7, "uploader");
            return Observable.create(new ImageUploadManager$wrapUploader$1(r6, r7));
        L14:
            if (r3.o == false) goto L20;
            glb.b.a.getClass();
            Intrinsics.checkNotNullParameter(r6, "uploadImage");
            glb.a r8 = r6.n;
            if (r8 == null) goto L20;
            if (r8.a == null) goto L20;
            AppreciableKit.Companion.getInstance().spanStart(r8.a, "data_load_cost");
            goto L20
        }
    }

    static {
        a = CoreThreadPool.getDefault().getCachedThreadPool();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v17, types: [com.ss.android.lark.image.uploader.upload.ImageUploadManager$batchUpload$1] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static void a(final ImageUploadTask r15) {
        int r0 = hlb.c.a;
        Intrinsics.checkNotNullParameter(r15, "imageUploadTask");
        int r1 = com.ss.android.lark.image.uploader.utils.c.a;
        com.ss.android.lark.image.uploader.utils.c.c("TransformManager", "Transform begin");
        dlb.a r2 = r15.f;
        if (r2 == null) goto L5;
        r2.e();
    L5:
        ArrayList<d> r3 = r15.c;
        com.ss.android.lark.image.uploader.utils.c.c("TransformManager", "Transform list size:" + r3.size());
        ArrayList<com.ss.android.lark.image.uploader.entity.b> r4 = r15.b;
        com.ss.android.lark.image.uploader.utils.c.c("TransformManager", "UploadImage list size:" + r4.size());
        Iterator<com.ss.android.lark.image.uploader.entity.b> r5 = r4.iterator();
        boolean r6 = false;
        int r7 = 0;
    L7:
        if (r5.hasNext() == false) goto L21;
        com.ss.android.lark.image.uploader.entity.b r8 = r5.next();
        int r9 = r7 + 1;
        if (r7 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        com.ss.android.lark.image.uploader.entity.b r10 = r8;
        if (r7 != 0) goto L14;
        glb.b.a.getClass();
        glb.b.d(r10);
    L14:
        Iterator<d> r11 = r3.iterator();
    L16:
        if (r11.hasNext() == false) goto L20;
        d r12 = r11.next();
        boolean r13 = r12.a(r10, r15);
        int r14 = com.ss.android.lark.image.uploader.utils.c.a;
        com.ss.android.lark.image.uploader.utils.c.c("TransformManager", "transform:" + r12.getName() + ", handle:" + r13 + ", image:" + r10);
        if (r13 == false) goto L16;
        String r16 = r12.b(r10, r15);
        com.ss.android.lark.image.uploader.utils.c.c("TransformManager", "path after do transform:" + r16);
        r10.getClass();
        Intrinsics.checkNotNullParameter(r16, "<set-?>");
        r10.a = r16;
        goto L16
    L20:
        r7 = r9;
        goto L7
    L21:
        ArrayList<com.ss.android.lark.image.uploader.entity.b> r17 = r15.b;
        int r18 = 0;
    L23:
        if (r18 >= r17.size()) goto L25;
        com.ss.android.lark.image.uploader.entity.b r19 = (com.ss.android.lark.image.uploader.entity.b) ListProtector.get(r17, r18);
        r19.k = com.ss.android.lark.image.uploader.utils.b.d(r19.a, true, false);
        r18 = r18 + 1;
        goto L23
    L25:
        dlb.a r20 = r15.f;
        if (r20 == null) goto L28;
        r20.f(r15.b);
    L28:
        int r21 = com.ss.android.lark.image.uploader.utils.c.a;
        com.ss.android.lark.image.uploader.utils.c.c("TransformManager", "Transform end");
        alb.a r22 = alb.b.b(r15);
        com.ss.android.lark.image.uploader.utils.c.c("ImageUploadManager", "FileSizeValid:" + r22.a());
        if (r22.a() == true) goto L34;
        dlb.a r23 = r15.f;
        if (r23 == null) goto L88;
        r23.j(r22.a, r22.b, r22.c, r22.d, r22.e);
        return;
    L88:
        return;
    L34:
        alb.a r24 = alb.c.b(r15);
        com.ss.android.lark.image.uploader.utils.c.c("ImageUploadManager", "FileTypeValid:" + r24.a());
        if (r24.a() == true) goto L40;
        dlb.a r25 = r15.f;
        if (r25 == null) goto L89;
        r25.j(r24.a, r24.b, 0, r22.d, r22.e);
        return;
    L89:
        return;
    L40:
        e r26 = r15.g;
        if (r26 == null) goto L43;
        boolean r27 = r26.b();
    L45:
        if (r15.b.size() != 1) goto L47;
        r6 = true;
    L47:
        e r28 = r15.g;
        if (r27 == true) goto L56;
        if (r6 == true) goto L56;
        if (r28 == null) goto L56;
        com.ss.android.lark.image.uploader.utils.c.c("ImageUploadManager", "Compress and upload serial");
        Ref.BooleanRef r29 = new Ref.BooleanRef();
        dlb.a r30 = r15.f;
        if (r30 == null) goto L55;
        r30.b(r15.b);
    L55:
        Observable r31 = Observable.fromIterable(r15.b).subscribeOn(LarkRxSchedulers.io()).observeOn(LarkRxSchedulers.io()).concatMap(new a(r15)).concatMapDelayError(new C0253b(r29, r15, r28)).observeOn(AndroidSchedulers.mainThread());
        int r32 = h.a;
        Intrinsics.checkNotNullParameter(r15, "uploadTask");
        r31.subscribe(new g(r15));
        return;
    L56:
        int r33 = blb.c.a;
        Intrinsics.checkNotNullParameter(r15, "imageUploadTask");
        com.ss.android.lark.image.uploader.utils.c.c("ImageCompressManager", "Compress begin");
        ArrayList<com.ss.android.lark.image.uploader.entity.b> r34 = r15.b;
        dlb.a r35 = r15.f;
        if (r35 == null) goto L59;
        r35.b(r34);
    L59:
        com.ss.android.lark.image.uploader.utils.c.c("ImageCompressManager", "UploadImage list size:" + r34.size());
        Iterator<com.ss.android.lark.image.uploader.entity.b> r36 = r34.iterator();
    L61:
        if (r36.hasNext() == false) goto L63;
        com.ss.android.lark.image.uploader.entity.b r37 = r36.next();
        glb.b.a.getClass();
        glb.b.e(r37);
        long r38 = System.currentTimeMillis();
        String r39 = r37.a;
        blb.c.c(r37, r15);
        r37.m = blb.c.a(r39, r37.a, r38);
        int r40 = com.ss.android.lark.image.uploader.utils.c.a;
        com.ss.android.lark.image.uploader.utils.c.a("ImageCompressManager", "compressInfo:" + r37.m);
        glb.b.f(r37);
        goto L61
    L63:
        dlb.a r41 = r15.f;
        if (r41 == null) goto L66;
        r41.c();
    L66:
        int r42 = com.ss.android.lark.image.uploader.utils.c.a;
        com.ss.android.lark.image.uploader.utils.c.c("ImageCompressManager", "Compress end");
        int r43 = h.a;
        Intrinsics.checkNotNullParameter(r15, "uploadTask");
        com.ss.android.lark.image.uploader.utils.c.c("ImageUploadManager", "Upload begin");
        dlb.a r44 = r15.f;
        if (r44 == null) goto L69;
        r44.g();
    L69:
        ArrayList<com.ss.android.lark.image.uploader.entity.b> r45 = r15.b;
        com.ss.android.lark.image.uploader.utils.c.c("ImageUploadManager", "UploadImage list size:" + r45.size());
        e r46 = r15.g;
        if (r46 != 0) goto L76;
        com.ss.android.lark.image.uploader.utils.c.c("ImageUploadManager", "uploader is null, finish task:" + r15);
        dlb.a r110 = r15.f;
        if (r110 == null) goto L74;
        r110.h();
    L74:
        com.ss.android.lark.image.uploader.utils.c.c("ImageUploadManager", "Upload end");
        return;
    L76:
        if (r46.b() == false) goto L78;
        com.ss.android.lark.image.uploader.utils.c.c("ImageUploadManager", "uploader support batch mode, upload once");
        final ArrayList<com.ss.android.lark.image.uploader.entity.b> r47 = r15.b;
        r46.c(r47, new ImageUploadManager$batchUpload$1(r47, r15));
        return;
    L78:
        Observable r48 = Observable.fromIterable(r45).subscribeOn(LarkRxSchedulers.io()).observeOn(LarkRxSchedulers.io()).concatMapDelayError(new f(r46));
        Intrinsics.checkNotNullParameter(r15, "uploadTask");
        r48.observeOn(AndroidSchedulers.mainThread()).subscribe(new g(r15));
        return;
    L43:
        r27 = false;
        goto L45
    }
}
