package np9;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.net.Uri;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.larus.bmhome.chat.component.bottom.attachment.d1;
import com.larus.photopicker.v2.impl.MediaSelectorFragment;
import com.larus.photopicker.v2.impl.MediaSelectorListFragment;
import com.larus.photopicker.v2.impl.databinding.LarusFragmentGalleryBinding;
import com.larus.photopicker.v2.impl.databinding.LarusFragmentMediaListBinding;
import com.larus.photopicker.v2.impl.databinding.LarusFragmentMediaSelectorBinding;
import com.larus.photopicker.v2.impl.e0;
import com.larus.photopicker.v2.impl.f0;
import com.larus.photopicker.v2.impl.injectinput.InjectInputCoordinator$registerInjectInputLifecycleCallbacks$callbacks$1;
import com.larus.photopicker.v2.impl.m2;
import com.larus.photopicker.v2.impl.viewmodel.BottomSheetViewModel;
import com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel;
import com.larus.platform.model.preview.AttachmentSnapshot;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import op8.h;
import op8.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class g implements h {
    public final Fragment a;
    public final LarusFragmentGalleryBinding b;
    public final BottomSheetViewModel c;
    public final MediaGalleryLiveDataViewModel d;
    public final String e;
    public final Function1<List<String>, Unit> f;
    public final String g;
    public final Lazy h;
    public op8.g i;
    public Set<? extends Uri> j;
    public boolean k;
    public Set<? extends Uri> l;
    public boolean m;
    public boolean n;
    public boolean o;
    public InjectInputCoordinator$registerInjectInputLifecycleCallbacks$callbacks$1 p;
    public FragmentManager q;

    public final class a extends op8.c {
        public final /* synthetic */ g a;

        public a(g r1) {
            this.a = r1;
        }

        public final void A3(List<String> r4) {
            Intrinsics.checkNotNullParameter(r4, "uriList");
            int r0 = e0.a;
            e0.d(this.a.g, "onCameraCaptureSuccess: count=" + r4.size());
            this.a.f.invoke(r4);
        }

        public final boolean c(String r4) {
            Intrinsics.checkNotNullParameter(r4, "content");
            int r0 = e0.a;
            e0.d(this.a.g, "onSend: contentLength=" + r4.length());
            Fragment r5 = this.a.a;
        L3:
            if (r5 == null) goto L8;
            if ((r5 instanceof lp9.c) == true) goto L6;
            r5 = r5.getParentFragment();
            goto L3
        L6:
            ((lp9.c) r5).zK();
        L8:
            Context r6 = this.a.a.getContext();
        L9:
            if (r6 == null) goto L31;
            if ((r6 instanceof lp9.c) == true) goto L12;
            if ((r6 instanceof ContextWrapper) == false) goto L18;
            if ((r6 instanceof Activity) == true) goto L18;
            r6 = ((ContextWrapper) r6).getBaseContext();
        L18:
            r6 = null;
            goto L9
        L12:
            ((lp9.c) r6).zK();
            return false;
        L31:
            return false;
        }

        public final void f4(View r2) {
            Intrinsics.checkNotNullParameter(r2, "inputView");
            int r3 = e0.a;
            e0.d(this.a.g, "onHideInputView");
            MediaSelectorFragment r4 = this.a.d();
            if (r4 != null) goto L5;
            return;
        L5:
            if (r4.f == null) goto L10;
            r4.V90().getInjectInputFooterHeight().setValue(0);
            return;
        }

        public final void h0(Uri r4) {
            int r0 = e0.a;
            String r1 = this.a.g;
            StringBuilder r2 = new StringBuilder("onAttachmentDeleted: hasUri=");
            if (r4 == null) goto L5;
            boolean r3 = true;
        L6:
            r2.append(r3);
            e0.d(r1, r2.toString());
            op8.g r5 = this.a.i;
            if (r5 == null) goto L9;
            r5.h0(r4);
        L9:
            final g r6 = this.a;
            r6.d.removeSelectionByUri(r4, new f(r6));
            return;
        L5:
            r3 = false;
            goto L6
        }

        public final void M7(View r7, final String r8) {
            Intrinsics.checkNotNullParameter(r7, "inputView");
            Intrinsics.checkNotNullParameter(r8, "addedItemUri");
            int r1 = e0.a;
            e0.d(this.a.g, "onShowInputView");
            g r2 = this.a;
            int r3 = r7.getHeight();
            MediaSelectorFragment r4 = r2.d();
            if (r4 != null) goto L5;
        L8:
            g r5 = this.a;
            final int r9 = r7.getHeight();
            MediaSelectorFragment r6 = r5.d();
            if (r6 == null) goto L33;
            Intrinsics.checkNotNullParameter(r8, "addedItemUri");
            if (r6.f != null) goto L13;
            return;
        L13:
            if (r8.length() != 0) goto L15;
            boolean r10 = true;
        L16:
            if (r10 == true) goto L36;
            LarusFragmentMediaSelectorBinding r11 = r6.f;
            final MediaSelectorListFragment r12 = null;
            if (r11 != null) goto L21;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r11 = null;
        L21:
            int r13 = r11.g.getCurrentItem();
            Fragment r14 = r6.getChildFragmentManager().findFragmentByTag("f" + r13);
            if ((r14 instanceof MediaSelectorListFragment) == false) goto L24;
            r12 = (MediaSelectorListFragment) r14;
        L24:
            if (r12 == null) goto L35;
            Intrinsics.checkNotNullParameter(r8, "addedItemUri");
            LarusFragmentMediaListBinding r0 = r12.f;
            if (r0 != null) goto L29;
            return;
        L29:
            if (r12.g == null) goto L38;
            r0.c.post(new m2(r12, r8, r9));
            return;
        L38:
            return;
        L35:
            return;
        L36:
            return;
        L15:
            r10 = false;
            goto L16
        L33:
            return;
        L5:
            if (r4.f == null) goto L8;
            r4.V90().getInjectInputFooterHeight().setValue(Integer.valueOf(r3));
            goto L8
        }
    }

    public static final class b implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public b(d r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    public final boolean S0() {
        if (this.d.isInjectInputMode() == false) goto L13;
        op8.g r0 = this.i;
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == false) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (r0.lr() != true) goto L9;
        r1 = true;
        goto L10
    L13:
        return false;
    }

    public final op8.d a() {
        Fragment r0 = this.i;
        if ((r0 instanceof Fragment) == false) goto L5;
        Fragment r1 = r0;
    L6:
        if (r1 != null) goto L8;
        return null;
    L8:
        return s1a.a.g(r1).getAbility(op8.d.class);
    L5:
        r1 = null;
        goto L6
    }

    public final boolean c() {
        if (this.o == true) goto L5;
    L7:
        return false;
    L5:
        if (a() == null) goto L7;
        return true;
    }

    public final MediaSelectorFragment d() {
        if (this.a.isAdded() == true) goto L5;
    L13:
        int r0 = e0.a;
        e0.d(this.g, "findMediaSelectorFragment skipped: hostFragment is not available");
        return null;
    L5:
        if (this.a.isDetached() == true) goto L13;
        if (this.a.getView() == null) goto L13;
        Fragment r1 = this.a.getChildFragmentManager().findFragmentById(this.b.g.getId());
        if ((r1 instanceof MediaSelectorFragment) == true) goto L12;
        return null;
    L12:
        return (MediaSelectorFragment) r1;
    }

    public final void h() {
        InjectInputCoordinator$registerInjectInputLifecycleCallbacks$callbacks$1 r0 = this.p;
        if (r0 != null) goto L5;
        return;
    L5:
        FragmentManager r1 = this.q;
        if (r1 == null) goto L8;
        r1.unregisterFragmentLifecycleCallbacks(r0);
    L8:
        this.p = null;
        this.q = null;
    }

    public final op8.b f() {
        op8.d r0 = a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.snapshot();
    }

    public final boolean b(op8.a r2) {
        Intrinsics.checkNotNullParameter(r2, "mutation");
        op8.d r0 = a();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.w00(r2) != true) goto L7;
        return true;
    }

    public final void e(op8.g r8) {
        int r0 = e0.a;
        e0.d(this.g, "onInjectInputReady");
        this.i = r8;
        boolean r1 = true;
        this.o = true;
        k r2 = s1a.a.g(this.a).a(k.class);
        if (r2 != null) goto L5;
    L17:
        BottomSheetViewModel r3 = this.c;
        if (r3 == null) goto L27;
        MutableLiveData<Integer> r4 = r3.getBottomSheetOnStateChanged();
        if (r4 == null) goto L27;
        Integer r5 = (Integer) r4.getValue();
        if (r5 == null) goto L27;
        if (r5.intValue() != 3) goto L27;
    L28:
        r8.O9(r1);
        Set<? extends Uri> r9 = this.l;
        if (r9 == null) goto L32;
        this.l = null;
        g(r9);
        return;
    L32:
        return;
    L27:
        r1 = false;
        goto L28
    L5:
        if (r2.a() != null) goto L7;
    L9:
        boolean r6 = false;
    L10:
        r2.c = r6;
        if (r6 == false) goto L16;
        Set<? extends Uri> r7 = this.l;
        if (r7 == null) goto L15;
        this.j = r7;
    L15:
        this.l = null;
    L16:
        e0.d(this.g, "[quickAlbumSharedInput] inputReady=" + r2.c);
        goto L17
    L7:
        if (a() == null) goto L9;
        r6 = true;
        goto L10
    }

    public final void g(Set<? extends Uri> r10) {
        op8.g r0 = this.i;
        if (this.o == false) goto L58;
        if (r0 == null) goto L58;
        Set r1 = SetsKt.minus(r10, this.j);
        Set r2 = SetsKt.minus(this.j, r10);
        int r3 = e0.a;
        e0.d(this.g, "syncSelectionToAttachment: addedCount=" + r1.size() + ", removedCount=" + r2.size());
        if (this.d.getUiConfig().d == true) goto L9;
    L22:
        Iterator r4 = r1.iterator();
    L24:
        if (r4.hasNext() == false) goto L26;
        r0.LQ((Uri) r4.next());
        goto L24
    L26:
        Iterator r5 = r2.iterator();
    L28:
        if (r5.hasNext() == false) goto L50;
        Uri r6 = (Uri) r5.next();
        if (uy8.b.c() == false) goto L46;
        op8.b r7 = f();
        if (r7 == null) goto L46;
        List r8 = r7.b;
        if (r8 == null) goto L46;
        Iterator r9 = r8.iterator();
    L38:
        if (r9.hasNext() == false) goto L42;
        Object r11 = r9.next();
        if (Intrinsics.areEqual(d1.c((AttachmentSnapshot) r11), r6.toString()) == false) goto L38;
    L43:
        AttachmentSnapshot r12 = (AttachmentSnapshot) r11;
        if (r12 == null) goto L46;
        boolean r13 = b(new op8.a.c(r12.getStableId(), r6.toString()));
    L47:
        if (r13 == true) goto L28;
        r0.Ed(r6);
        goto L28
    L42:
        r11 = null;
    L46:
        r13 = false;
        goto L47
    L50:
        if (uy8.b.c() == false) goto L52;
    L56:
        this.j = r10;
        return;
    L52:
        if (r10.isEmpty() == false) goto L56;
        if ((!this.j.isEmpty()) == false) goto L56;
        r0.ru();
        goto L56
    L9:
        if ((!r1.isEmpty()) == false) goto L22;
        if (this.j.isEmpty() == false) goto L22;
        op8.b r14 = f();
        if (r14 == null) goto L19;
        List r15 = r14.b;
        if (r15 == null) goto L19;
        if ((!r15.isEmpty()) != true) goto L19;
        boolean r16 = true;
    L20:
        if (r16 == false) goto L22;
        r0.ru();
    L19:
        r16 = false;
    L58:
        this.l = r10;
    }

    public g(Fragment r2, LarusFragmentGalleryBinding r3, BottomSheetViewModel r4, MediaGalleryLiveDataViewModel r5, String r6, f0 r7) {
        Intrinsics.checkNotNullParameter(r2, "hostFragment");
        Intrinsics.checkNotNullParameter(r3, "binding");
        Intrinsics.checkNotNullParameter(r5, "mediaGalleryViewModel");
        Intrinsics.checkNotNullParameter(r7, "onCameraCaptureSuccess");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = "InjectInputCoordinator";
        this.h = LazyKt.lazy(new e(this));
        this.j = SetsKt.emptySet();
    }
}
