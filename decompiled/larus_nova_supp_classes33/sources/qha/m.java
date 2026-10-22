package qha;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.instruction.core.model.ActionBarExecutionType;
import com.larus.bmhome.view.actionbar.BaseActionBarHolder;
import com.larus.bmhome.view.actionbar.custom.t1;
import com.obric.assistant.common.spi.IObricUIService;
import com.obric.assistant.impl.databinding.ObricItemCustomActionbarNormalHolderBinding;
import com.obric.assistant.spi.actionbar.ObricSpecialInputType;
import com.obric.assistant.view.actionbar.custom.ObricPhoneOperationSegmentCell;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;
import wa8.u1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class m extends e {
    public final t1a.b d;
    public final Context e;
    public final String f;
    public final boolean g;

    @Override // qha.e
    public final String k() {
        return "obric_phone_operation";
    }

    @Override // qha.e
    public final long p() {
        return -761162256;
    }

    @Override // qha.e
    public final int q() {
        return 2131911902;
    }

    @Override // qha.e
    public final int r() {
        return 2131244361;
    }

    @Override // qha.e
    public final int m() {
        return ActionBarExecutionType.OBRIC_ACTION.getValue();
    }

    @Override // qha.e
    public final com.larus.bmhome.actionbar.model.r o() {
        return new com.larus.bmhome.actionbar.model.r(Integer.valueOf(ObricSpecialInputType.SPECIAL_INPUT.getType()), null, null, null, null, null, null, null, 4094);
    }

    @Override // qha.e
    public Context getContext() {
        return this.e;
    }

    @Override // qha.e
    public final String l() {
        return this.f;
    }

    @Override // qha.e
    public final z0 j(z0 r8) {
        Intrinsics.checkNotNullParameter(r8, "item");
        boolean r0 = this.g;
        r8.y = r0;
        if (r0 == false) goto L5;
        u1 r1 = new u1(getContext().getString(2131911901), ContextCompat.getColor(getContext(), v19.c.b(2130972123, getContext(), 2131103203)), ContextCompat.getColor(getContext(), v19.c.b(2130973611, getContext(), 2131105590)));
    L6:
        r8.z = r1;
        return r8;
    L5:
        r1 = null;
        goto L6
    }

    public m(t1a.b r3, Context r4) {
        Intrinsics.checkNotNullParameter(r3, "vContext");
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter("", "address");
        super(r3, r4, "");
        this.d = r3;
        this.e = r4;
        this.f = "";
        this.g = false;
    }

    @Override // qha.e
    public final BaseActionBarHolder f(ViewGroup r5, t1 r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        Intrinsics.checkNotNullParameter(r6, "defaultClickCallback");
        ObricItemCustomActionbarNormalHolderBinding r8 = ObricItemCustomActionbarNormalHolderBinding.a(LayoutInflater.from(r5.getContext()), r5);
        IObricUIService r0 = (IObricUIService) ServiceManager.get().getService(IObricUIService.class);
        if (r0 == null) goto L6;
        r0.na(new TextView[]{r8.d, r8.e});
    L6:
        return new ObricPhoneOperationSegmentCell(r8, r6, r7);
    }
}
