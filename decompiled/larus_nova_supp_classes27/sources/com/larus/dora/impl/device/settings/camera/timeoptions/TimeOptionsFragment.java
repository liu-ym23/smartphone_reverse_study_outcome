package com.larus.dora.impl.device.settings.camera.timeoptions;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewGroupKt;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextSelector;
import com.larus.dora.impl.databinding.LarusDoraPageOptionsBinding;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.util.b0;
import com.larus.utils.e1;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import m49.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 #2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0014H\u0002J\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u00112\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002¢\u0006\u0002\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0018\u0010!\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u001cH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/larus/dora/impl/device/settings/camera/timeoptions/TimeOptionsFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraPageOptionsBinding;", "pageType", "Lcom/larus/dora/impl/device/settings/camera/timeoptions/TimeOptionsPageType;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "getCurrentPageName", "", "getPageMaskView", "setupTitle", "Lcom/larus/bmhome/view/NovaTitleBarEx;", "titleText", "setPrefer", "optionList", "", "Lcom/larus/dora/impl/device/settings/camera/timeoptions/TimeOptionModel;", "(Ljava/util/List;)Lkotlin/Unit;", "updateSelectItemView", "value", "", "onItemSelectorViewClicked", "option", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TimeOptionsFragment extends DoraBaseFragment {
    public static final /* synthetic */ int h = 0;
    public LarusDoraPageOptionsBinding f;
    public TimeOptionsPageType g;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        LarusDoraPageOptionsBinding r0 = this.f;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c;
    }

    public final String k() {
        if (this.g != TimeOptionsPageType.INTERVAL) goto L5;
        return "continuous_photo_interval";
    L5:
        return "exploration_mode_duration";
    }

    public TimeOptionsFragment() {
    }

    public final void W90(int r5) {
        LarusDoraPageOptionsBinding r0 = this.f;
        if (r0 == null) goto L7;
        ItemGroup r1 = r0.b;
        if (r1 == null) goto L7;
        Sequence r2 = ViewGroupKt.getChildren(r1);
    L8:
        if (r2 != null) goto L10;
        r2 = SequencesKt.emptySequence();
    L10:
        Iterator r3 = r2.iterator();
    L12:
        if (r3.hasNext() == false) goto L14;
        View r4 = (View) r3.next();
        r4.setSelected(Intrinsics.areEqual(r4.getTag(), Integer.valueOf(r5)));
        goto L12
    L14:
        return;
    L7:
        r2 = null;
        goto L8
    }

    public final void onViewCreated(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r10, r11);
        Bundle r12 = getArguments();
        if (r12 == null) goto L5;
        String r13 = r12.getString("options_title");
    L6:
        if (r13 != null) goto L8;
        r13 = "";
    L8:
        Bundle r0 = getArguments();
        if (r0 == null) goto L11;
        List r1 = r0.getParcelableArrayList("options_data");
    L12:
        if (r1 != null) goto L14;
        r1 = CollectionsKt.emptyList();
    L14:
        LarusDoraPageOptionsBinding r2 = this.f;
        if (r2 == null) goto L21;
        NovaTitleBarEx r3 = r2.d;
        NovaTitleBarEx.Y5(r3, r13, null, null, 6);
        NovaTitleBarEx.b6(r3, 2131240517, false, null, null, new m49.a(this), 14);
        if (Intrinsics.areEqual(r13, getString(2131902353)) == false) goto L19;
        TimeOptionsPageType r14 = TimeOptionsPageType.INTERVAL;
    L20:
        this.g = r14;
        goto L21
    L19:
        r14 = TimeOptionsPageType.MAX_DURATION;
    L21:
        LarusDoraPageOptionsBinding r15 = this.f;
        if (r15 == null) goto L41;
        Context r16 = getContext();
        if (r16 == null) goto L39;
        r15.b.removeAllViews();
        int r4 = r1.size();
        Iterator r5 = r1.iterator();
        int r6 = 0;
    L28:
        if (r5.hasNext() == false) goto L39;
        int r7 = r6 + 1;
        final TimeOptionModel r8 = (TimeOptionModel) r5.next();
        ItemTextSelector r9 = new ItemTextSelector(r16);
        r9.setText(r8.a);
        if (r4 != 1) goto L32;
        int r17 = 2131239210;
    L38:
        r9.setBackgroundResource(r17);
        r9.setTag(Integer.valueOf(r8.b));
        e1.d(r9, new b(this, r8));
        r15.b.addView(r9, new ViewGroup.LayoutParams(-1, -1));
        r6 = r7;
        goto L28
    L32:
        if (r6 != 0) goto L35;
        r17 = 2131239212;
        goto L38
    L35:
        if (r6 != (r4 - 1)) goto L37;
        r17 = 2131239215;
        goto L38
    L37:
        r17 = 2131239218;
    L39:
        Unit r18 = Unit.INSTANCE;
    L41:
        if (this.g != TimeOptionsPageType.INTERVAL) goto L43;
        b0.a.getClass();
        W90(b0.j().getInt("dora_burst_take_image_interval", 5));
        return;
    L43:
        b0.a.getClass();
        W90(b0.j().getInt("dora_burst_take_image_max_duration", 10800));
        return;
    L11:
        r1 = null;
        goto L12
    L5:
        r13 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        LarusDoraPageOptionsBinding r4 = LarusDoraPageOptionsBinding.a(r1, r2);
        this.f = r4;
        return r4.a;
    }
}
