package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.imagepicker;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.provider.MediaStore;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.bdlocation.BuildConfig;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 32\u00020\u0001:\u00014B\u0007¢\u0006\u0004\b1\u00102J\u0012\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\fJ\u0006\u0010\u000e\u001a\u00020\u0004J\u0006\u0010\u000f\u001a\u00020\u0004J*\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u001a\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\nJ\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010R8\u0010\u0016\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n0\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR*\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010%\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001b\u00100\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/¨\u00065"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/likeegg/imagepicker/ImagePickViewModel;", "Landroidx/lifecycle/ViewModel;", BuildConfig.FLAVOR, "loadMore", BuildConfig.FLAVOR, "loadImage", BuildConfig.FLAVOR, "page", "Ljava/util/ArrayList;", BuildConfig.FLAVOR, "Lkotlin/collections/ArrayList;", "getImages", BuildConfig.FLAVOR, "getInitImagePaths", "loadMoreImages", "tryFirstTimeLoad", "Landroid/os/Bundle;", "outState", "imagePaths", "saveState", "restoreState", "Landroidx/lifecycle/MutableLiveData;", "mImagePathsBuffer", "Landroidx/lifecycle/MutableLiveData;", "getMImagePathsBuffer", "()Landroidx/lifecycle/MutableLiveData;", "setMImagePathsBuffer", "(Landroidx/lifecycle/MutableLiveData;)V", "mInitImagePaths", "Ljava/util/ArrayList;", "mCurrentPageIndex", "I", "getMCurrentPageIndex", "()I", "setMCurrentPageIndex", "(I)V", "Landroid/content/ContentResolver;", "mContentResolver", "Landroid/content/ContentResolver;", "getMContentResolver", "()Landroid/content/ContentResolver;", "setMContentResolver", "(Landroid/content/ContentResolver;)V", "Lio/reactivex/disposables/CompositeDisposable;", "cd$delegate", "Lkotlin/Lazy;", "getCd", "()Lio/reactivex/disposables/CompositeDisposable;", "cd", "<init>", "()V", "Companion", "a", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ImagePickViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String KEY_CURRENT_PAGE = "page_index";
    private static final String KEY_IMAGE_PATHS = "image_paths";
    public static final String ORDER_BY = "datetaken DESC";
    private static final String TAG = "ImagePickViewModel";
    private final Lazy cd$delegate;
    private ContentResolver mContentResolver;
    private int mCurrentPageIndex;
    private MutableLiveData<ArrayList<String>> mImagePathsBuffer;
    private ArrayList<String> mInitImagePaths;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements ObservableOnSubscribe {
        public final /* synthetic */ ImagePickViewModel a;

        public b(ImagePickViewModel r1) {
            this.a = r1;
        }

        public final void subscribe(ObservableEmitter<ArrayList<String>> r3) {
            Intrinsics.checkNotNullParameter(r3, "emitter");
            ImagePickViewModel r0 = this.a;
            r3.onNext(ImagePickViewModel.access$getImages(r0, r0.getMCurrentPageIndex()));
            r3.onComplete();
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ ImagePickViewModel a;

        public c(ImagePickViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            ArrayList r4 = (ArrayList) r3;
            ALogger.d(ImagePickViewModel.TAG, "load image success, size: " + r4.size());
            this.a.getMImagePathsBuffer().setValue(r4);
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r2) {
            ALogger.e(ImagePickViewModel.TAG, (Throwable) r2);
        }
    }

    static {
        Companion = new a();
    }

    private final CompositeDisposable getCd() {
        return (CompositeDisposable) this.cd$delegate.getValue();
    }

    public final void tryFirstTimeLoad() {
        loadImage(false);
    }

    public final List<String> getInitImagePaths() {
        ArrayList<String> r0 = this.mInitImagePaths;
        this.mInitImagePaths = null;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return Collections.nCopies(50, BuildConfig.FLAVOR);
    }

    public final void loadMoreImages() {
        ALogger.d(TAG, "start load more");
        loadImage(true);
    }

    public ImagePickViewModel() {
        this.mImagePathsBuffer = new MutableLiveData();
        this.cd$delegate = LazyKt.lazy(ImagePickViewModel$cd$2.INSTANCE);
    }

    public final ContentResolver getMContentResolver() {
        return this.mContentResolver;
    }

    public final int getMCurrentPageIndex() {
        return this.mCurrentPageIndex;
    }

    public final MutableLiveData<ArrayList<String>> getMImagePathsBuffer() {
        return this.mImagePathsBuffer;
    }

    private final ArrayList<String> getImages(int r13) {
        int r14 = r13 * 50;
        ArrayList<String> r1 = new ArrayList();
        String r9 = "datetaken DESC LIMIT 50 OFFSET " + r14;
        Cursor r2 = null;
    L33:
        th = th;
    L48:
        ALogger.e(TAG, th);     // Catch: Throwable -> L40
        if (r2 != null) goto L37;
    L39:
        return r1;
    L37:
        if (r2.isClosed() == true) goto L39;
        r2.close();
    L40:
        th = move-exception;
        if (r2 != null) goto L43;
    L45:
        throw th;
    L43:
        if (r2.isClosed() == true) goto L45;
        r2.close();
        goto L45
    L5:
        if (Build.VERSION.SDK_INT < 26) goto L9;
        Bundle r3 = new Bundle();     // Catch: Throwable -> L33
        r3.putString("android:query-arg-sql-sort-order", r9);     // Catch: Throwable -> L33
        r3.putInt("android:query-arg-sort-direction", 1);     // Catch: Throwable -> L33
        r3.putStringArray("android:query-arg-sort-columns", new String[]{"date_added"});     // Catch: Throwable -> L33
        r3.putInt("android:query-arg-offset", r14);     // Catch: Throwable -> L33
        r3.putInt("android:query-arg-limit", 50);     // Catch: Throwable -> L33
        ContentResolver r15 = this.mContentResolver;     // Catch: Throwable -> L33
        if (r15 == null) goto L13;
        Cursor r16 = com_bytedance_android_livesdk_interactivity_publicscreen_topcontainer_likeegg_imagepicker_ImagePickViewModel_android_content_ContentResolver_query(r15, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id", "_data"}, r3, null);     // Catch: Throwable -> L33
    L14:
        if (r16 != null) goto L46;
        return r1;
    L46:
        r16.isAfterLast();     // Catch: Throwable -> L30
        Cursor r0 = r16;     // Catch: Throwable -> L30
        Cursor r4 = r0;     // Catch: Throwable -> L25
        if (r4.moveToFirst() == false) goto L20;
    L18:
        r1.add(r4.getString(r4.getColumnIndex("_data")));     // Catch: Throwable -> L25
        if (r4.moveToNext() == true) goto L18;
    L20:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L25
        CloseableKt.closeFinally(r0, null);     // Catch: Throwable -> L30
        if (r16.isClosed() == true) goto L39;
        r16.close();
        goto L39
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        CloseableKt.closeFinally(r0, th);     // Catch: Throwable -> L30
        throw th;     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        r2 = r16;
        th = th;
    L13:
        r16 = null;
        goto L14
    L9:
        ContentResolver r6 = this.mContentResolver;     // Catch: Throwable -> L33
        if (r6 == null) goto L13;
        r16 = com_bytedance_android_livesdk_interactivity_publicscreen_topcontainer_likeegg_imagepicker_ImagePickViewModel_android_content_ContentResolver_query(r6, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id", "_data"}, null, null, r9);     // Catch: Throwable -> L33
        goto L14
    }

    private final void loadImage(boolean r3) {
        if (r3 == false) goto L4;
        this.mCurrentPageIndex++;
    L5:
        RxUtilKt.c(Observable.create(new b(this)).compose(RxUtil.rxSchedulerHelper()).subscribe(new c(this), d.a), getCd());
        return;
    L4:
        this.mCurrentPageIndex = 0;
        goto L5
    }

    public final void restoreState(Bundle r3) {
        Intrinsics.checkNotNullParameter(r3, "outState");
        this.mCurrentPageIndex = r3.getInt(KEY_CURRENT_PAGE, 0);
        this.mInitImagePaths = r3.getStringArrayList(KEY_IMAGE_PATHS);
    }

    public final void setMContentResolver(ContentResolver r1) {
        this.mContentResolver = r1;
    }

    public final void setMCurrentPageIndex(int r1) {
        this.mCurrentPageIndex = r1;
    }

    public final void setMImagePathsBuffer(MutableLiveData<ArrayList<String>> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mImagePathsBuffer = r2;
    }

    public static final /* synthetic */ ArrayList access$getImages(ImagePickViewModel r0, int r1) {
        return r0.getImages(r1);
    }

    public final void saveState(Bundle r2, ArrayList<String> r3) {
        Intrinsics.checkNotNullParameter(r2, "outState");
        if (r3 == null) goto L5;
        r2.putStringArrayList(KEY_IMAGE_PATHS, r3);
    L5:
        r2.putInt(KEY_CURRENT_PAGE, this.mCurrentPageIndex);
    }

    public static /* synthetic */ void loadImage$default(ImagePickViewModel r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.loadImage(r1);
    }

    private static Cursor com_bytedance_android_livesdk_interactivity_publicscreen_topcontainer_likeegg_imagepicker_ImagePickViewModel_android_content_ContentResolver_query(ContentResolver r13, Uri r14, String[] r15, Bundle r16, CancellationSignal r17) {
        f06.c r8 = new f06.c();
        Object[] r9 = {r14, r15, r16, r17};
        f06.b r10 = new f06.b();
        f06.d r11 = r8.b(240004, "android/content/ContentResolver", "query", r13, r9, "android.database.Cursor", r10);
        if (r11.a == false) goto L6;
        r8.a(240004, "android/content/ContentResolver", "query", r13, r9, null, r10, false);
        return (Cursor) r11.b;
    L6:
        Cursor r18 = r13.query(r14, r15, r16, r17);
        r8.a(240004, "android/content/ContentResolver", "query", r13, r9, r18, r10, true);
        return r18;
    }

    private static Cursor com_bytedance_android_livesdk_interactivity_publicscreen_topcontainer_likeegg_imagepicker_ImagePickViewModel_android_content_ContentResolver_query(ContentResolver r13, Uri r14, String[] r15, String r16, String[] r17, String r18) {
        f06.c r8 = new f06.c();
        Object[] r9 = {r14, r15, r16, r17, r18};
        f06.b r10 = new f06.b();
        f06.d r11 = r8.b(240004, "android/content/ContentResolver", "query", r13, r9, "android.database.Cursor", r10);
        if (r11.a == false) goto L6;
        r8.a(240004, "android/content/ContentResolver", "query", r13, r9, null, r10, false);
        return (Cursor) r11.b;
    L6:
        Cursor r19 = r13.query(r14, r15, r16, r17, r18);
        r8.a(240004, "android/content/ContentResolver", "query", r13, r9, r19, r10, true);
        return r19;
    }
}
