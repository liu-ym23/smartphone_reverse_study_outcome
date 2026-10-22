package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.openplatform.impl.base.OpenPlatformAnchorServiceImpl;
import com.bytedance.android.live.openplatform.impl.base.view.settingdialog.OpenPlatformBottomSettingDialog;
import com.bytedance.android.live.openplatform.impl.base.view.settingdialog.SettingItemView;
import com.bytedance.android.live.openplatform.impl.miniappanchor.view.DefaultOpenFirstExplainCardSettingItemView;
import com.bytedance.android.live.openplatform.impl.miniappanchor.view.MemorySwitchSettingItemView;
import com.bytedance.android.live.openplatform.impl.miniappanchor.view.OffShelfSettingItemView;
import com.bytedance.android.live.openplatform.impl.miniappanchor.view.ShowImportantCardView;
import com.bytedance.android.live.openplatform.impl.miniappanchor.view.ShowLiveDataSettingItemView;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import com.bytedance.android.livesdk.config.ee0;
import com.bytedance.android.livesdk.config.uc1;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/management/view/ShelfManagementSettingDialog;", "Lcom/bytedance/android/live/openplatform/impl/base/view/settingdialog/OpenPlatformBottomSettingDialog;", "", "<init>", "()V", "b", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShelfManagementSettingDialog extends OpenPlatformBottomSettingDialog {
    public static final /* synthetic */ int j = 0;
    public Map<Integer, View> e;
    public so0.a f;
    public View g;
    public ShowImportantCardView h;
    public final /* synthetic */ com.bytedance.android.live.openplatform.impl.base.utils.a i;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ ShelfManagementSettingDialog a;

        public a(ShelfManagementSettingDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            ShelfManagementSettingDialog r0 = this.a;
            boolean r4 = ((com.bytedance.android.live.openplatform.impl.miniappanchor.memory.j) r3).a;
            int r1 = ShelfManagementSettingDialog.j;
            r0.Y90(r4);
        }
    }

    public static final class b {
        public static void a(AppCompatActivity r2, Bundle r3) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            ShelfManagementSettingDialog r0 = new ShelfManagementSettingDialog();
            r0.setArguments(r3);
            FragmentManager r4 = r2.getSupportFragmentManager();
            LandscapeRestrictionOperation r5 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, "ShelfManagementSettingDialog", r5);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r4, r0, r5) == true) goto L11;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
        L6:
            r0.show(r4, "ShelfManagementSettingDialog");
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.view.settingdialog.OpenPlatformBottomSettingDialog
    public final String W90() {
        return "设置";
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.view.settingdialog.OpenPlatformBottomSettingDialog
    public final void S90() {
        this.e.clear();
    }

    public ShelfManagementSettingDialog() {
        com.bytedance.android.live.openplatform.impl.base.utils.a r0 = new com.bytedance.android.live.openplatform.impl.base.utils.a();
        this.i = r0;
        this.e = new LinkedHashMap();
        OpenPlatformAnchorServiceImpl.Companion.getClass();
        so0.a r1 = (so0.a) ((po0.a.b) OpenPlatformAnchorServiceImpl.access$getDiComponent$cp()).a().a.b.get();
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        this.f = r1;
        Disposable r2 = xs2.b.a().b(com.bytedance.android.live.openplatform.impl.miniappanchor.memory.j.class).subscribe(new a(this));
        if (r2 == null) goto L6;
        Intrinsics.checkNotNullParameter(r2, "$this$autoDispose");
        r0.a(r2);
        return;
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.view.settingdialog.OpenPlatformBottomSettingDialog
    public final List<SettingItemView> V90() {
        Context r0 = getContext();
        if (r0 == null) goto L16;
        ArrayList r1 = new ArrayList();
        r1.add(new MemorySwitchSettingItemView(r0));
        r1.add(new DefaultOpenFirstExplainCardSettingItemView(r0));
        if (((uc1) ee0.a.getValue()).u() != 1) goto L7;
        r1.add(new ShowLiveDataSettingItemView(r0));
    L7:
        Bundle r3 = getArguments();
        if (r3 == null) goto L10;
        String r4 = r3.getString("app_id");
    L11:
        Bundle r5 = getArguments();
        if (r5 == null) goto L14;
        r5.getString("schema");
    L14:
        r1.add(new OffShelfSettingItemView(r0, r4));
        return r1;
    L10:
        r4 = null;
        goto L11
    L16:
        return CollectionsKt.emptyList();
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        this.i.b();
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.view.settingdialog.OpenPlatformBottomSettingDialog
    public final void onDestroyView() {
        super.onDestroyView();
        S90();
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.view.settingdialog.OpenPlatformBottomSettingDialog
    public final View T90(int r3) {
        if (this.e != null) goto L5;
        this.e = new LinkedHashMap();
    L5:
        View r0 = this.e.get(Integer.valueOf(r3));
        if (r0 != null) goto L14;
        View r1 = getView();
        if (r1 == null) goto L12;
        View r2 = r1.findViewById(r3);
        if (r2 == null) goto L12;
        this.e.put(Integer.valueOf(r3), r2);
        return r2;
    L12:
        return null;
    L14:
        return r0;
    }

    public final void Y90(boolean r10) {
        ShowImportantCardView r0 = this.h;
        if (r0 == null) goto L5;
        ViewParent r1 = r0.getParent();
    L6:
        boolean r2 = false;
        if (r1 == null) goto L9;
    L30:
        if (r10 == false) goto L48;
        View r11 = this.g;
        if (r11 == null) goto L34;
        r11.setVisibility(0);
    L34:
        ShowImportantCardView r12 = this.h;
        if (r12 == null) goto L37;
        r12.setVisibility(0);
    L37:
        ShowImportantCardView r13 = this.h;
        if (r13 == null) goto L58;
        LiveSwitchButton r3 = r13.b;
        if (r3 == null) goto L59;
        so0.a r14 = r13.a;
        if (r14 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L45:
        if (r14.getMemoryStatus().d != 1) goto L47;
        r2 = true;
    L47:
        r3.setChecked(r2);
        return;
    L59:
        return;
    L58:
        return;
    L48:
        View r15 = this.g;
        if (r15 == null) goto L51;
        r15.setVisibility(8);
    L51:
        ShowImportantCardView r16 = this.h;
        if (r16 == null) goto L61;
        r16.setVisibility(8);
        return;
    L61:
        return;
    L9:
        if (this.h != null) goto L14;
        Context r4 = getContext();
        if (r4 == null) goto L14;
        this.g = U90();
        this.h = new ShowImportantCardView(r4);
    L14:
        if (this.h == null) goto L30;
        Iterator r5 = UtilityKotlinExtentionsKt.g((ViewGroup) T90(2131385987)).iterator();
        int r6 = -1;
        int r7 = 0;
    L17:
        if (r5.hasNext() == false) goto L27;
        Object r8 = r5.next();
        int r9 = r7 + 1;
        if (r7 >= 0) goto L21;
        CollectionsKt.throwIndexOverflow();
    L21:
        View r17 = (View) r8;
        if ((r17 instanceof DefaultOpenFirstExplainCardSettingItemView) == false) goto L24;
    L25:
        r6 = r7;
    L26:
        r7 = r9;
        goto L17
    L24:
        if ((r17 instanceof ShowLiveDataSettingItemView) == false) goto L26;
    L27:
        if (r6 == (-1)) goto L29;
        ((LinearLayout) T90(2131385987)).addView(this.g, r6 + 1);
        ((LinearLayout) T90(2131385987)).addView(this.h, r6 + 2);
        goto L30
    L29:
        ((LinearLayout) T90(2131385987)).addView(this.g);
        ((LinearLayout) T90(2131385987)).addView(this.h);
        goto L30
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.view.settingdialog.OpenPlatformBottomSettingDialog
    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        so0.a r4 = this.f;
        if (r4 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L6:
        if (r4.getMemoryStatus().d == (-1)) goto L8;
        boolean r5 = true;
    L9:
        Y90(r5);
        return;
    L8:
        r5 = false;
        goto L9
    }
}
