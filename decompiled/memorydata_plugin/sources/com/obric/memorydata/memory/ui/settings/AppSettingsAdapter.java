package com.obric.memorydata.memory.ui.settings;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.ui.custom.DeviceAdaptiveCardListItem;
import com.obric.oui.button.OButton;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u0017\u0018\u0019B=\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0013H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/AppSettingsAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/obric/memorydata/memory/ui/settings/AppSettingItem;", "Lcom/obric/memorydata/memory/ui/settings/AppSettingsAdapter$ViewHolder;", "context", "Landroid/content/Context;", "onAppSettingChanged", "Lkotlin/Function2;", "", "", "", "onDownLoadClick", "Lkotlin/Function1;", "<init>", "(Landroid/content/Context;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "Companion", "ViewHolder", "AppSettingDiffCallback", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AppSettingsAdapter extends ListAdapter<c, ViewHolder> {
    public static final a Companion = null;
    private static final String TAG = "MemoryAppSettingsAdapter";
    private final Context context;
    private final Function2<String, Boolean, Unit> onAppSettingChanged;
    private final Function1<c, Unit> onDownLoadClick;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/AppSettingsAdapter$AppSettingDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/obric/memorydata/memory/ui/settings/AppSettingItem;", "<init>", "()V", "areItemsTheSame", "", "oldItem", "newItem", "areContentsTheSame", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class AppSettingDiffCallback extends DiffUtil.ItemCallback<c> {
        public AppSettingDiffCallback() {
        }

        /* JADX INFO: renamed from: areContentsTheSame, reason: avoid collision after fix types in other method */
        public boolean areContentsTheSame2(c r1, c r2) {
            Intrinsics.checkNotNullParameter(r1, "oldItem");
            Intrinsics.checkNotNullParameter(r2, "newItem");
            return Intrinsics.areEqual(r1, r2);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public /* synthetic */ boolean areContentsTheSame(c r3, c r4) {
            return areContentsTheSame2((c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.memorydata.plugin"), (c) ZeusTransformUtils.preCheckCast(r4, c.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: areItemsTheSame, reason: avoid collision after fix types in other method */
        public boolean areItemsTheSame2(c r1, c r2) {
            Intrinsics.checkNotNullParameter(r1, "oldItem");
            Intrinsics.checkNotNullParameter(r2, "newItem");
            return Intrinsics.areEqual(r1.b(), r2.b());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public /* synthetic */ boolean areItemsTheSame(c r3, c r4) {
            return areItemsTheSame2((c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.memorydata.plugin"), (c) ZeusTransformUtils.preCheckCast(r4, c.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/AppSettingsAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "listItemView", "Lcom/obric/oui/lisitem/OCardListItem;", "<init>", "(Lcom/obric/oui/lisitem/OCardListItem;)V", "getListItemView", "()Lcom/obric/oui/lisitem/OCardListItem;", "appSwitch", "Lcom/obric/oui/oswitch/OSwitch;", "getAppSwitch", "()Lcom/obric/oui/oswitch/OSwitch;", "download", "Lcom/obric/oui/button/OButton;", "getDownload", "()Lcom/obric/oui/button/OButton;", "appIcon", "Landroid/widget/ImageView;", "getAppIcon", "()Landroid/widget/ImageView;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView appIcon;
        private final OSwitch appSwitch;
        private final OButton download;
        private final OCardListItem listItemView;

        public ViewHolder(OCardListItem r7) {
            Intrinsics.checkNotNullParameter(r7, "listItemView");
            super((View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.memorydata.plugin"));
            this.listItemView = r7;
            View r0 = r7.getCustomEndView();
            OButton r3 = null;
            if (r0 == null) goto L5;
            OSwitch r1 = (OSwitch) ZeusTransformUtils.preCheckCast(r0.findViewById(ZeusTransformUtils.mapRes(R.id.trail_usage_app_install_switch, OaidModel.KEY_ID, "trail_usage_app_install_switch")), OSwitch.class, "com.obric.memorydata.plugin");
        L6:
            this.appSwitch = r1;
            View r2 = r7.getCustomEndView();
            if (r2 == null) goto L9;
            r3 = (OButton) ZeusTransformUtils.preCheckCast(r2.findViewById(ZeusTransformUtils.mapRes(R.id.trail_usage_app_install_button, OaidModel.KEY_ID, "trail_usage_app_install_button")), OButton.class, "com.obric.memorydata.plugin");
        L9:
            this.download = r3;
            this.appIcon = r7.getIconView();
            return;
        L5:
            r1 = null;
            goto L6
        }

        public final ImageView getAppIcon() {
            return this.appIcon;
        }

        public final OSwitch getAppSwitch() {
            return this.appSwitch;
        }

        public final OButton getDownload() {
            return this.download;
        }

        public final OCardListItem getListItemView() {
            return this.listItemView;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/AppSettingsAdapter$Companion;", "", "<init>", "()V", "TAG", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new a(null);
    }

    public AppSettingsAdapter(Context r4, Function2<? super String, ? super Boolean, Unit> r5, Function1<? super c, Unit> r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Function2<String, Boolean, Unit> r8 = (Function2) ZeusTransformUtils.wrapperContextForParams(r5, Function2.class, "com.obric.memorydata.plugin");
        Function1<c, Unit> r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "onAppSettingChanged");
        Intrinsics.checkNotNullParameter(r9, "onDownLoadClick");
        super((DiffUtil.ItemCallback) ZeusTransformUtils.preCheckCast(new AppSettingDiffCallback(), DiffUtil.ItemCallback.class, "com.obric.memorydata.plugin"));
        this.context = ZeusTransformUtils.wrapperContext(r7, "com.obric.memorydata.plugin");
        this.onAppSettingChanged = r8;
        this.onDownLoadClick = r9;
    }

    /* JADX INFO: renamed from: lambda$-BOVCTyHHecw6sc-PC9h-y-xkMg, reason: not valid java name */
    public static /* synthetic */ void m969lambda$BOVCTyHHecw6scPC9hyxkMg(AppSettingsAdapter r0, c r1, View r2) {
        onBindViewHolder$lambda$2(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$KKWTt_IeLkHgzpCy979iL_N93sY(AppSettingsAdapter r0, c r1, CompoundButton r2, boolean r3) {
        onBindViewHolder$lambda$1(r0, r1, r2, r3);
    }

    private static final void onBindViewHolder$lambda$1(AppSettingsAdapter r2, c r3, CompoundButton r4, boolean r5) {
        RunLog.INSTANCE.debug(TAG, "appSwitch isChecked: " + r5);
        r2.onAppSettingChanged.invoke(r3.b(), Boolean.valueOf(r5));
    }

    private static final void onBindViewHolder$lambda$2(AppSettingsAdapter r0, c r1, View r2) {
        Function1<c, Unit> r3 = r0.onDownLoadClick;
        Intrinsics.checkNotNull(r1);
        r3.invoke(r1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
        onBindViewHolder((ViewHolder) ZeusTransformUtils.preCheckCast(r3, ViewHolder.class, "com.obric.memorydata.plugin"), r4);
    }

    public void onBindViewHolder(ViewHolder r21, int r22) {
        Intrinsics.checkNotNullParameter(r21, "holder");
        final c r2 = (c) ZeusTransformUtils.preCheckCast(getItem(r22), c.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "=== onBindViewHolder: pos=" + r22 + ", pkg=" + r2.b() + ", checked=" + r2.e() + ", pending=" + r2.g() + ", display=" + r2.h() + " ===", false, 4, null);
        OSwitch r4 = r21.getAppSwitch();
        if (r4 == null) goto L5;
        r4.setOnCheckedChangeListener(null);
    L5:
        com.obric.memorydata.utils.icon.b.a(com.obric.memorydata.utils.icon.b.f13229a, this.context, r21.getAppIcon(), r2.b(), null, 0, null, null, null, null, false, 1016, null);
        r21.getListItemView().setTitle((CharSequence) ZeusTransformUtils.preCheckCast(r2.a(), CharSequence.class, "com.obric.memorydata.plugin"));
        r21.getListItemView().setSubTitle((CharSequence) ZeusTransformUtils.preCheckCast(r2.c(), CharSequence.class, "com.obric.memorydata.plugin"));
        if (com.obric.memorydata.utils.c.f13193a.a(r2.b()) == false) goto L8;
    L19:
        OButton r5 = r21.getDownload();
        if (r5 == null) goto L22;
        r5.setVisibility(8);
    L22:
        OSwitch r6 = r21.getAppSwitch();
        if (r6 == null) goto L25;
        r6.setVisibility(0);
    L25:
        OSwitch r7 = r21.getAppSwitch();
        if (r7 == null) goto L28;
        r7.setChecked(r2.h());
    L28:
        OSwitch r8 = r21.getAppSwitch();
        if (r8 == null) goto L31;
        r8.setEnabled(r2.d());
    L31:
        OSwitch r9 = r21.getAppSwitch();
        if (r9 == null) goto L34;
        r9.setClickable(r2.d());
    L34:
        OSwitch r10 = r21.getAppSwitch();
        if (r10 == null) goto L37;
        r10.setOnCheckedChangeListener(new $$Lambda$AppSettingsAdapter$KKWTt_IeLkHgzpCy979iL_N93sY(this, r2));
    L37:
        OCardListItem r3 = r21.getListItemView();
        if (getItemCount() < 2) goto L45;
        if (r22 != 0) goto L42;
        OCardListItem.a(r3, 1, false, 2, null);
    L46:
        r3.e(true);
        r3.b(true);
        r3.f(false);
        r3.c(true);
        r3.d(true);
        return;
    L42:
        if (r22 != (getItemCount() - 1)) goto L44;
        OCardListItem.a(r3, 3, false, 2, null);
        goto L46
    L44:
        OCardListItem.a(r3, 2, false, 2, null);
        goto L46
    L45:
        OCardListItem.a(r3, 0, false, 2, null);
        goto L46
    L8:
        if (Intrinsics.areEqual(r2.b(), "assistant.history") == true) goto L19;
        OButton r11 = r21.getDownload();
        if (r11 == null) goto L13;
        r11.setVisibility(0);
    L13:
        OSwitch r12 = r21.getAppSwitch();
        if (r12 == null) goto L16;
        r12.setVisibility(8);
    L16:
        OButton r13 = r21.getDownload();
        if (r13 == null) goto L37;
        r13.setOnClickListener(new $$Lambda$AppSettingsAdapter$BOVCTyHHecw6scPC9hyxkMg(this, r2));
        goto L37
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return (RecyclerView.ViewHolder) ZeusTransformUtils.preCheckCast(onCreateViewHolder(r1, r2), RecyclerView.ViewHolder.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "parent");
        DeviceAdaptiveCardListItem r9 = new DeviceAdaptiveCardListItem(this.context, null, 0, 6, null);
        r9.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        r9.setCardType(1);
        OCardListItem.a((OCardListItem) ZeusTransformUtils.preCheckCast(r9, OCardListItem.class, "com.obric.memorydata.plugin"), 2, false, 2, null);
        r9.setCustomEndView(ZeusTransformUtils.mapRes(R.layout.item_memory_settings_usage_app_tailview, "layout", "item_memory_settings_usage_app_tailview"));
        return new ViewHolder((OCardListItem) ZeusTransformUtils.preCheckCast(r9, OCardListItem.class, "com.obric.memorydata.plugin"));
    }
}
