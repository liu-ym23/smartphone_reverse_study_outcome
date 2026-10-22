package com.larus.camera.impl.ui.component.result.general.viewpager;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.camera.api.params.OutputParam;
import com.larus.camera.impl.ui.fragment.CameraResultFragment;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\bH\u0002J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000f\u001a\u00020\rJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\rJ\u0014\u0010\u0016\u001a\u00020\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0018J\u0006\u0010\u0019\u001a\u00020\rJ\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\rH\u0016J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001bH\u0016J\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/larus/camera/impl/ui/component/result/general/viewpager/ResultPreviewFragmentAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "fragment", "Landroidx/fragment/app/Fragment;", "supportMarkable", "", "resultList", "", "Lcom/larus/camera/impl/ui/component/result/general/viewpager/ResultDisplayParam;", "<init>", "(Landroidx/fragment/app/Fragment;ZLjava/util/List;)V", "fragments", "getItemCount", "", "createFragment", "position", "getPreviewFragment", "param", "getFragment", "Lcom/larus/camera/impl/ui/component/result/general/viewpager/IMultiPreview;", "removeFragment", "", "addFragment", "addList", "", "getFragmentCount", "getItemId", "", "containsItem", "itemId", "getCurrentList", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ResultPreviewFragmentAdapter extends FragmentStateAdapter {
    public final boolean a;
    public final List<ResultDisplayParam> b;
    public final List<Fragment> c;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[OutputParam.ResultType.values().length];
            r0[OutputParam.ResultType.VIDEO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[OutputParam.ResultType.PHOTO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public final int getItemCount() {
        return this.b.size();
    }

    public final boolean containsItem(long r7) {
        List<ResultDisplayParam> r0 = this.b;
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L27;
        String r2 = ((ResultDisplayParam) r1.next()).getOutputKey();
        if (r2 == null) goto L13;
        int r3 = r2.hashCode();
    L15:
        if (r3 != r7) goto L17;
        boolean r4 = true;
    L18:
        if (r4 == false) goto L9;
        return true;
    L17:
        r4 = false;
        goto L18
    L13:
        r3 = 0;
        goto L15
    L27:
        return false;
    L5:
        if (r0.isEmpty() == false) goto L7;
        return false;
    }

    public final Fragment createFragment(int r4) {
        FLogger.a.i("ResultPreviewFragmentAdapter", "createFragment " + this.b + " position:" + r4);
        return (Fragment) ListProtector.get(this.c, r4);
    }

    public final long getItemId(int r3) {
        String r4 = ((ResultDisplayParam) ListProtector.get(this.b, r3)).getOutputKey();
        if (r4 == null) goto L5;
        int r5 = r4.hashCode();
    L7:
        return r5;
    L5:
        r5 = 0;
        goto L7
    }

    public final d y2(int r3) {
        if (r3 >= 0) goto L5;
        return null;
    L5:
        if (r3 >= ((ArrayList) this.c).size()) goto L13;
        Object r4 = ListProtector.get(this.c, r3);
        if ((r4 instanceof d) == true) goto L10;
        return null;
    L10:
        return (d) r4;
    L13:
        return null;
    }

    public final BasePreviewFragment z2(ResultDisplayParam r7) {
        OutputParam.ResultType r0 = r7.getResultType();
        int r1 = b.a[r0.ordinal()];
        boolean r2 = true;
        if (r1 != 1) goto L5;
        int r3 = VideoFragment.i;
        Intrinsics.checkNotNullParameter(r7, "displayParam");
        VideoFragment r4 = new VideoFragment();
        Bundle r5 = new Bundle();
        r5.putSerializable("display_param", r7);
        r4.setArguments(r5);
        return r4;
    L5:
        if (r1 != 2) goto L23;
        Intrinsics.checkNotNullParameter(r7, "<this>");
        if (r7.getResultType() != OutputParam.ResultType.PHOTO) goto L15;
        String r6 = r7.getPath();
        if (r6 == null) goto L11;
        String r8 = StringsKt.substringAfterLast(r6, '.', "");
    L13:
        if (StringsKt.equals(r8, "gif", true) == false) goto L15;
    L16:
        if (r2 == false) goto L19;
        int r9 = GifPreviewFragment.i;
        Intrinsics.checkNotNullParameter(r7, "displayParam");
        GifPreviewFragment r10 = new GifPreviewFragment();
        Bundle r11 = new Bundle();
        r11.putSerializable("display_param", r7);
        r10.setArguments(r11);
        return r10;
    L19:
        if (this.a == false) goto L21;
        int r12 = MarkableImageFragment.i;
        Intrinsics.checkNotNullParameter(r7, "displayParam");
        MarkableImageFragment r13 = new MarkableImageFragment();
        Bundle r14 = new Bundle();
        r14.putSerializable("display_param", r7);
        r13.setArguments(r14);
        return r13;
    L21:
        int r15 = ImageFragment.i;
        Intrinsics.checkNotNullParameter(r7, "displayParam");
        ImageFragment r16 = new ImageFragment();
        Bundle r17 = new Bundle();
        r17.putSerializable("display_param", r7);
        r16.setArguments(r17);
        return r16;
    L11:
        r8 = null;
    L15:
        r2 = false;
        goto L16
    L23:
        throw new NoWhenBranchMatchedException();
    }

    public ResultPreviewFragmentAdapter(CameraResultFragment r2, boolean r3, List r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r4, "resultList");
        super(r2);
        this.a = r3;
        this.b = r4;
        this.c = new ArrayList();
        Iterator r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ResultDisplayParam r6 = (ResultDisplayParam) r5.next();
        List<Fragment> r7 = this.c;
        ArrayList r8 = (ArrayList) r7;
        r8.add(z2(r6));
        goto L4
    }
}
