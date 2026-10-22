package aca;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBindings;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.OUserSelectBlock;
import com.larus.im.bean.message.block.OUserSelectButton;
import com.larus.platform.api.g1;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.block.base.CheckLastMessageBlockHolder;
import com.obric.assistant.card.databinding.ObricImBlockUserSelectBinding;
import com.obric.assistant.card.databinding.ObricImBlockUserSelectBtnBinding;
import com.obric.assistant.permission.IObricPermissionService;
import com.obric.assistant.settings.SelectableToggleItem;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Function;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Deprecated(message = "use OmniButtonGroupBlockHolder instead")
public final class v extends CheckLastMessageBlockHolder<aca.b> {
    public ObricImBlockUserSelectBinding p;
    public final List<ObricImBlockUserSelectBtnBinding> q;
    public Message r;
    public final Map<String, Function1<OUserSelectBlock, Unit>> s;

    public static final class a {
    }

    public static final class b {
        public final List<SelectableToggleItem> a;
        public final List<SelectableToggleItem> b;
        public final List<SelectableToggleItem> c;
        public final List<String> d;
        public final List<String> e;
        public final boolean f;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
            if (this.f == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "DataSourcePermissionRequest(toggleList=" + this.a + ", toggleWithPermissionList=" + this.b + ", toggleWithoutPermissionList=" + this.c + ", permissionList=" + this.d + ", batchPermissionList=" + this.e + ", isAlbumOnlyToggle=" + this.f + ')';
        }

        public b(List<SelectableToggleItem> r2, List<SelectableToggleItem> r3, List<SelectableToggleItem> r4, List<String> r5, List<String> r6, boolean r7) {
            Intrinsics.checkNotNullParameter(r2, "toggleList");
            Intrinsics.checkNotNullParameter(r3, "toggleWithPermissionList");
            Intrinsics.checkNotNullParameter(r4, "toggleWithoutPermissionList");
            Intrinsics.checkNotNullParameter(r5, "permissionList");
            Intrinsics.checkNotNullParameter(r6, "batchPermissionList");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
        }
    }

    public static final class c {
        public final boolean a;
        public final List<String> b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            int r0 = 1231;
        L7:
            return (r0 * 31) + this.b.hashCode();
        L5:
            r0 = 1237;
            goto L7
        }

        public final String toString() {
            return "SystemPermissionResult(isCanceledOrFailed=" + this.a + ", grantedList=" + this.b + ')';
        }

        public c(boolean r2, List<String> r3) {
            Intrinsics.checkNotNullParameter(r3, "grantedList");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class d implements g1.c {
        public final /* synthetic */ String a;
        public final /* synthetic */ Function2<Boolean, Boolean, Unit> b;
        public final /* synthetic */ List<String> c;

        public final void onGoSettingsDialogShow() {
        }

        public final void onSettingPageReturn() {
            List<String> r0 = this.c;
            boolean r2 = true;
            if ((r0 instanceof Collection) == true) goto L5;
        L7:
            Iterator<T> r1 = r0.iterator();
        L9:
            if (r1.hasNext() == false) goto L18;
            String r3 = (String) r1.next();
            IObricPermissionService r4 = (IObricPermissionService) ServiceManager.get().getService(IObricPermissionService.class);
            if (r4 != null) goto L13;
        L15:
            boolean r5 = false;
        L16:
            if (r5 == true) goto L9;
            r2 = false;
            goto L18
        L13:
            if (r4.checkPermission(r3) != true) goto L15;
            r5 = true;
        L18:
            FLogger.a.i("UserSelectBlockHolder", "requestPermission " + this.c + " return from setting page, result: " + r2);
            this.b.invoke(Boolean.FALSE, Boolean.valueOf(r2));
            return;
        L5:
            if (r0.isEmpty() == false) goto L7;
            goto L7
        }

        public final void onGoSettingsDialogDismiss(boolean r3) {
            if (r3 == true) goto L5;
            FLogger.a.i("UserSelectBlockHolder", "requestPermission " + this.a + " onGoSettingsDialogCancel");
            this.b.invoke(Boolean.TRUE, Boolean.FALSE);
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public d(String r1, Function2<? super Boolean, ? super Boolean, Unit> r2, List<String> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void onResult(boolean r2, List<String> r3, List<String> r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r3, "grantedList");
            Intrinsics.checkNotNullParameter(r4, "deniedList");
            if (r5 == false) goto L5;
            return;
        L5:
            FLogger.a.i("UserSelectBlockHolder", "requestPermission " + this.a + " onResult: " + r2);
            this.b.invoke(Boolean.FALSE, Boolean.valueOf(r2));
        }
    }

    public static final class e implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public e(Function1 r2) {
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

    static {
    }

    public v() {
        this.q = new ArrayList();
        this.s = new LinkedHashMap();
    }

    @Override // com.obric.assistant.block.base.CheckLastMessageBlockHolder
    public final void i() {
        super.i();
        FLogger.a.i("UserSelectBlockHolder", "onViewRecycled");
    }

    public static void p(ObricImBlockUserSelectBtnBinding r3) {
        r3.b.setEnabled(false);
        r3.b.setAlpha(0.6f);
        r3.b.setTextColor(ContextCompat.getColor(r3.a.getContext(), 2131103794));
        r3.b.setOnClickListener(null);
    }

    public static FragmentActivity r(Context r1) {
    L2:
        if (r1 == null) goto L10;
        if ((r1 instanceof FragmentActivity) == true) goto L6;
        if ((r1 instanceof ContextWrapper) == false) goto L15;
        r1 = ((ContextWrapper) r1).getBaseContext();
        goto L2
    L15:
        return null;
    L6:
        return (FragmentActivity) r1;
    L10:
        return null;
    }

    @Override // com.obric.assistant.block.base.CheckLastMessageBlockHolder
    public final void g(jc8.a r8) {
        aca.b r9 = (aca.b) r8;
        Intrinsics.checkNotNullParameter(r9, "blockModel");
        super.g(r9);
        Block r0 = ((jc8.a) r9).a;
        if (r0 == null) goto L7;
        BlockContent r1 = r0.getContent();
        if (r1 == null) goto L7;
        OUserSelectBlock r2 = r1.getOUserSelectBlock();
    L8:
        FLogger r3 = FLogger.a;
        r3.i("UserSelectBlockHolder", "onBindBlockView: userSelectBlock=" + r2 + ", blockId = " + ((jc8.a) r9).g);
        if (r2 != null) goto L11;
        r3.w("UserSelectBlockHolder", "onBindBlockView: userSelectBlock is null");
        return;
    L11:
        ObricImBlockUserSelectBinding r4 = this.p;
        if (r4 != null) goto L14;
        r3.w("UserSelectBlockHolder", "onBindBlockView: binding is null");
        return;
    L14:
        Map<String, Function1<OUserSelectBlock, Unit>> r5 = this.s;
        String r6 = ((jc8.a) r9).a.getBlockId();
        if (r6 != null) goto L17;
        r6 = NameKeys.UnloadStrategy_No_Strategy;
    L17:
        Function1 r7 = (Function1) ((LinkedHashMap) r5).get(r6);
        if (r7 == null) goto L20;
        r7.invoke(r2);
    L20:
        this.r = kc8.g.a(r9.i);
        r3.i("UserSelectBlockHolder", "onBindBlockView: curBlockMessage = " + this.r + ", isBlockEnabled = " + Intrinsics.areEqual(r2.enabled, Boolean.TRUE));
        t(r9, r2, r4);
        return;
    L7:
        r2 = null;
        goto L8
    }

    public final View h(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "viewGroup");
        FLogger.a.i("UserSelectBlockHolder", "onCreatedBlockView: viewGroup=" + r4);
        View r5 = LayoutInflater.from(r4.getContext()).inflate(2131564022, r4, false);
        LinearLayout r1 = (LinearLayout) ViewBindings.findChildViewById(r5, 2131364692);
        if (r1 == null) goto L11;
        RelativeLayout r6 = (RelativeLayout) r5;
        this.p = new ObricImBlockUserSelectBinding(r6, r1);
        ViewGroup.LayoutParams r0 = r6.getLayoutParams();
        if (r0 == null) goto L7;
        r0.width = -1;
    L8:
        r6.setLayoutParams(r0);
        return r6;
    L7:
        r0 = new ViewGroup.MarginLayoutParams(-1, -2);
        goto L8
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(2131364692)));
    }

    @Override // com.obric.assistant.block.base.CheckLastMessageBlockHolder
    public final void m(boolean r4) {
        FLogger.a.i("UserSelectBlockHolder", "onLastMessageStateChange: isLastestMessage = " + r4);
        if (r4 == true) goto L8;
        Iterator r5 = ((ArrayList) this.q).iterator();
    L6:
        if (r5.hasNext() == false) goto L10;
        p((ObricImBlockUserSelectBtnBinding) r5.next());
        goto L6
    L10:
        return;
    }

    public static c o(boolean r1, List r2, boolean r3) {
        if (r1 == true) goto L7;
        r2 = CollectionsKt.emptyList();
    L7:
        return new c(r3, r2);
    }

    public static void s(Context r4, List r5, Function2 r6) {
        String r0 = (String) CollectionsKt.firstOrNull(r5);
        if (r0 != null) goto L5;
        return;
    L5:
        FLogger.a.i("UserSelectBlockHolder", "goPermissionSettings, permissions: " + r5);
        FragmentActivity r7 = com.larus.utils.i.a(r4);
        if (r7 == null) goto L11;
        d r1 = new d(r0, r6, r5);
        IObricPermissionService r8 = (IObricPermissionService) ServiceManager.get().getService(IObricPermissionService.class);
        if (r8 == null) goto L12;
        r8.e(r7, r5, r1);
        return;
    L12:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r10v4 */
    public final void t(final aca.b r23, final OUserSelectBlock r24, final ObricImBlockUserSelectBinding r25) {
        cd8.a r0 = jc8.c.a(this, cd8.a.class);
        int r9 = 1;
        ?? r10 = 0;
        if (r0 == null) goto L13;
        Integer r1 = Integer.valueOf(r0.a);
        if (r1.intValue() <= 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L11;
        r1 = null;
    L11:
        if (r1 == null) goto L13;
        int r3 = r1.intValue();
    L14:
        ViewGroup.LayoutParams r4 = r25.a.getLayoutParams();
        if (r4 != null) goto L17;
    L19:
        boolean r5 = false;
    L20:
        if (r5 == true) goto L26;
        RelativeLayout r6 = r25.a;
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        if (r7 == null) goto L25;
        r7.width = r3;
        r6.setLayoutParams(r7);
        goto L26
    L25:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L26:
        r25.b.removeAllViews();
        ((ArrayList) this.q).clear();
        LayoutInflater r11 = LayoutInflater.from(r25.a.getContext());
        FLogger.a.i("UserSelectBlockHolder", "setDataToView: enabled = " + r24.enabled);
        boolean r13 = l();
        List r8 = r24.buttons;
        if (r8 == null) goto L58;
        List r12 = CollectionsKt.filterNotNull(r8);
        if (r12 == null) goto L58;
        Iterator r14 = r12.iterator();
        int r15 = 0;
    L32:
        if (r14.hasNext() == false) goto L58;
        Object r16 = r14.next();
        int r17 = r15 + 1;
        if (r15 >= 0) goto L36;
        CollectionsKt.throwIndexOverflow();
    L36:
        final OUserSelectButton r18 = (OUserSelectButton) r16;
        View r19 = r11.inflate(2131564023, r25.b, r10);
        if (r19 == null) goto L57;
        TextView r20 = (TextView) r19;
        ObricImBlockUserSelectBtnBinding r21 = new ObricImBlockUserSelectBtnBinding(r20, r20);
        Boolean r22 = r18.isSelected;
        Boolean r26 = Boolean.TRUE;
        if (Intrinsics.areEqual(r22, r26) == false) goto L43;
        String r27 = r18.textSelected;
        if (r27 == null) goto L45;
    L46:
        r20.setText(r27);
        we8.a.b(r20, i5.m(), false, null, null, 12);
        if (r15 < r9) goto L51;
        LinearLayout r28 = r25.b;
        View r29 = new View(r25.a.getContext());
        r29.setLayoutParams(new ViewGroup.LayoutParams(i5.h(), r10));
        r29.setVisibility(4);
        r28.addView(r29);
    L51:
        if (Intrinsics.areEqual(r24.enabled, r26) == false) goto L54;
        if (r13 == false) goto L54;
        r20.setAlpha(1.0f);
        ObricImBlockUserSelectBtnBinding r110 = r21;
        TextView r111 = r20;
        e1.d(r111, new aca.c(this, r23, r24, r18, r25));
    L55:
        ((ArrayList) this.q).add(r110);
        r25.b.addView(r111);
        r15 = r17;
        r9 = 1;
        r10 = 0;
    L54:
        r111 = r20;
        r110 = r21;
        p(r110);
    L45:
        r27 = NameKeys.UnloadStrategy_No_Strategy;
        goto L46
    L43:
        r27 = r18.textNormal;
        if (r27 != null) goto L46;
    L57:
        throw new NullPointerException("rootView");
    L58:
        List r30 = r24.buttons;
        if (r30 != null) goto L61;
    L64:
        boolean r31 = true;
    L65:
        if (r31 == true) goto L67;
        e1.x(r25.a);
        return;
    L67:
        FLogger.a.w("UserSelectBlockHolder", "setDataToView: buttons is empty");
        e1.o(r25.a);
        return;
    L61:
        if (r30.isEmpty() == true) goto L64;
        r31 = false;
        goto L65
    L17:
        if (r4.width != r3) goto L19;
        r5 = true;
        goto L20
    L7:
        r2 = false;
    L13:
        r3 = -1;
        goto L14
    }
}
