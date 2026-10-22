package com.larus.dora.impl.device.ailab.config;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemTextSelector;
import com.larus.dora.impl.databinding.LarusDoraPageOptionsBinding;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.util.b0;
import com.larus.utils.e1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import l49.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002¢\u0006\u0002\u0010\u0015J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0018\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0014H\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\u0007H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/larus/dora/impl/device/ailab/config/AutoStopTimeConfigFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraPageOptionsBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setPrefer", "optionList", "", "Lcom/larus/dora/impl/device/ailab/config/AutoStopTimeConfig;", "(Ljava/util/List;)Lkotlin/Unit;", "reportAutoStopTimeConfigChange", "previous", "", "current", "onItemSelectorViewClicked", "option", "getCurrentPageName", "", "getPageMaskView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AutoStopTimeConfigFragment extends DoraBaseFragment {
    public static final /* synthetic */ int g = 0;
    public LarusDoraPageOptionsBinding f;

    public static final class a {
    }

    static {
    }

    public final String k() {
        return "auto_stop_time_config";
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        LarusDoraPageOptionsBinding r0 = this.f;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c;
    }

    public AutoStopTimeConfigFragment() {
    }

    public final void onViewCreated(View r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r11, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r11, r12);
        LarusDoraPageOptionsBinding r13 = this.f;
        if (r13 == null) goto L5;
        NovaTitleBarEx r0 = r13.d;
        NovaTitleBarEx.Y5(r0, getString(2131902186), null, null, 6);
        NovaTitleBarEx.b6(r0, 2131240517, false, null, null, new l49.a(this), 14);
    L5:
        AutoStopTimeConfig.a r14 = AutoStopTimeConfig.Companion;
        b0.a.getClass();
        boolean r15 = b0.w();
        r14.getClass();
        List r16 = AutoStopTimeConfig.a.a(r15);
        LarusDoraPageOptionsBinding r17 = this.f;
        if (r17 == null) goto L32;
        Context r1 = getContext();
        if (r1 == null) goto L27;
        int r2 = b0.c();
        r17.b.removeAllViews();
        ArrayList r18 = (ArrayList) r16;
        int r3 = r18.size();
        Iterator r110 = r18.iterator();
        int r4 = 0;
    L12:
        if (r110.hasNext() == false) goto L27;
        int r5 = r4 + 1;
        final AutoStopTimeConfig r6 = (AutoStopTimeConfig) r110.next();
        ItemTextSelector r7 = new ItemTextSelector(r1);
        StringBuilder r8 = new StringBuilder();
        r8.append(r6.getValue());
        r8.append('s');
        r7.setText(r8.toString());
        boolean r9 = true;
        if (r3 != 1) goto L16;
        int r10 = 2131239210;
    L22:
        r7.setBackgroundResource(r10);
        if (r2 == r6.getValue()) goto L26;
        r9 = false;
    L26:
        r7.setSelected(r9);
        r7.setId(r6.getValue());
        e1.d(r7, new b(this, r6));
        r17.b.addView(r7, new ViewGroup.LayoutParams(-1, -1));
        r4 = r5;
        goto L12
    L16:
        if (r4 != 0) goto L19;
        r10 = 2131239212;
        goto L22
    L19:
        if (r4 != (r3 - 1)) goto L21;
        r10 = 2131239215;
        goto L22
    L21:
        r10 = 2131239218;
    L27:
        Unit r111 = Unit.INSTANCE;
        return;
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        LarusDoraPageOptionsBinding r4 = LarusDoraPageOptionsBinding.a(r1, r2);
        this.f = r4;
        return r4.a;
    }
}
