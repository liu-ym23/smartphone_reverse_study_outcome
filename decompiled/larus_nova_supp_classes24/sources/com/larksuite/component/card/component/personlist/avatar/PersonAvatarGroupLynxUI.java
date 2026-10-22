package com.larksuite.component.card.component.personlist.avatar;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.component.card.component.personlist.PersonInfo;
import com.larksuite.component.card.component.personlist.g;
import com.larksuite.component.card.utils.j;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.event.LynxEventDetail;
import com.ss.android.lark.log.Log;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\bH\u0014J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016¨\u0006\u0012"}, d2 = {"Lcom/larksuite/component/card/component/personlist/avatar/PersonAvatarGroupLynxUI;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Lcom/larksuite/component/card/component/personlist/avatar/PersonAvatarGroupView;", "context", "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "createView", "Landroid/content/Context;", "dispatchEvent", "", "event", "Lcom/lynx/tasm/event/LynxEventDetail;", "updateExtraData", "", "extraData", "", "Companion", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class PersonAvatarGroupLynxUI extends LynxUI<PersonAvatarGroupView> {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ rcc.a a;
        public final /* synthetic */ PersonAvatarGroupLynxUI b;
        public final /* synthetic */ List<PersonInfo> c;

        public b(rcc.a r1, PersonAvatarGroupLynxUI r2, List<PersonInfo> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            if (this.a.a() == false) goto L5;
            Log.e("PersonAvatarGroupLynxUI", "click avatar group check isDuplicate");
            return;
        L5:
            FragmentActivity r3 = j.getActivity(((PersonAvatarGroupView) this.b.getView()).getContext());
            if (r3 == null) goto L10;
            wy7.b.b(r3, this.c);
            return;
        }
    }

    static {
    }

    public PersonAvatarGroupLynxUI(LynxContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    public final View createView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        PersonAvatarGroupView r0 = new PersonAvatarGroupView(r4);
        g.a.getClass();
        r0.setLayoutParams(new ViewGroup.LayoutParams(-2, g.d(null)));
        return r0;
    }

    public final boolean dispatchEvent(LynxEventDetail r3) {
        if (r3 == null) goto L4;
        String r0 = r3.a.getName();
    L6:
        if (TextUtils.equals(r0, "tap") == false) goto L10;
        return true;
    L10:
        return super/*com.lynx.tasm.behavior.ui.LynxBaseUI*/.dispatchEvent(r3);
    L4:
        r0 = null;
        goto L6
    }

    public final void updateExtraData(Object r4) {
        super/*com.lynx.tasm.behavior.ui.LynxBaseUI*/.updateExtraData(r4);
        if (r4 != null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L11;
        PersonAvatarGroupShadowNode.b r5 = (PersonAvatarGroupShadowNode.b) r4;
        if (r5 == null) goto L12;
        ((PersonAvatarGroupView) getView()).setData(r5);
        List<PersonInfo> r6 = r5.c;
        rcc.a r1 = new rcc.a();
        ((PersonAvatarGroupView) getView()).setOnClickListener(new b(r1, this, r6));
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r0 = r4 instanceof PersonAvatarGroupShadowNode.b;
        goto L6
    }
}
