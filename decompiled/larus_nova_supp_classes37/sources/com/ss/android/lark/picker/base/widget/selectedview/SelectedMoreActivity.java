package com.ss.android.lark.picker.base.widget.selectedview;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larksuite.component.ui.avatar.v2.LarkAvatarView;
import com.larus.home.impl.utils.c;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter;
import com.ss.android.lark.base.fragment.BaseFragmentActivity;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.staging.SelectedMoreAdapter;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.base.view.avatar.AvatarHelperKt;
import com.ss.android.lark.picker.base.view.avatar.ExternalTargetAvatarProviderStore;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import uz7.a;
import v19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001c\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\u0006\b\u0001\u0012\u00020\u000f\u0012\u0004\u0012\u00020\f0\u000eX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/selectedview/SelectedMoreActivity;", "Lcom/ss/android/lark/base/fragment/BaseFragmentActivity;", "<init>", "()V", "titleBar", "Lcom/ss/android/lark/ui/CommonTitleBar;", "titleBarRightTv", "Landroid/widget/TextView;", "moreList", "Lcom/ss/android/lark/widget/recyclerview/CommonRecyclerView;", "selectedData", "", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "adapter", "Lcom/ss/android/lark/base/adapter/LarkRecyclerViewBaseAdapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "removedData", "isEnableChatPreview", "", "isUseResult", "useSimpleSelectedMoreStyle", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "updateRightTvBySelectedCount", "count", "", "SimpleSelectedMoreAdapter", "Companion", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class SelectedMoreActivity extends BaseFragmentActivity {
    public static final Companion Companion = null;
    private static final String ENABLE_CHAT_PREVIEW = "enableChatPreview";
    public static final String KEY_REMOVE_DATA = "removeData";
    private static final String KEY_SCENE = "keyScene";
    private static final String KEY_USE_DOU_BAO_STYLE = "keyUseDoubaoSelectedMoreStyle";
    private static final String KEY_USE_RESULT = "useResult";
    public static final String SELECTED_DATA = "selected.data";
    public static final String _TAG = "LarkSearch.SearchWidget.SelectedMoreActivity";
    private LarkRecyclerViewBaseAdapter<? extends RecyclerView.ViewHolder, SearchBaseInfo> adapter;
    private boolean isEnableChatPreview;
    private boolean isUseResult;
    private CommonRecyclerView moreList;
    private final List<SearchBaseInfo> removedData;
    private final List<SearchBaseInfo> selectedData;
    private CommonTitleBar titleBar;
    private TextView titleBarRightTv;
    private boolean useSimpleSelectedMoreStyle;

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JF\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u0014JP\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u0014J@\u0010\u001c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u0014J:\u0010\u001d\u001a\u00020\u001e*\u00020\u001e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0014H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/selectedview/SelectedMoreActivity$Companion;", "", "<init>", "()V", "_TAG", "", "SELECTED_DATA", "KEY_REMOVE_DATA", "ENABLE_CHAT_PREVIEW", "KEY_SCENE", "KEY_USE_RESULT", "KEY_USE_DOU_BAO_STYLE", "startForResult", "", "context", "Landroid/content/Context;", "data", "", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "isEnableChatPreview", "", "isUseResult", "scene", "requestCode", "", "useDoubaoSelectedMoreStyle", "fragment", "Landroidx/fragment/app/Fragment;", "startForResultInForseti", "applyParams", "Landroid/content/Intent;", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v2, types: [java.io.Serializable, java.lang.Object[]] */
        private final Intent applyParams(Intent r2, List<? extends SearchBaseInfo> r3, boolean r4, boolean r5, String r6, boolean r7) {
            r2.putExtra("selected.data", r3.toArray(new SearchBaseInfo[0]));
            r2.putExtra(SelectedMoreActivity.ENABLE_CHAT_PREVIEW, r4);
            r2.putExtra(SelectedMoreActivity.KEY_USE_RESULT, r5);
            r2.putExtra(SelectedMoreActivity.KEY_SCENE, r6);
            r2.putExtra(SelectedMoreActivity.KEY_USE_DOU_BAO_STYLE, r7);
            return r2;
        }

        public final void startForResultInForseti(Context r8, Fragment r9, List<? extends SearchBaseInfo> r10, boolean r11, String r12, boolean r13) {
            Intrinsics.checkNotNullParameter(r8, "context");
            Intrinsics.checkNotNullParameter(r10, "data");
            Intrinsics.checkNotNullParameter(r12, "scene");
            applyParams(new Intent(r8, SelectedMoreActivity.class), r10, r11, true, r12, r13);
        }

        public final void startForResult(Context r9, List<? extends SearchBaseInfo> r10, boolean r11, boolean r12, String r13, int r14, boolean r15) {
            Intrinsics.checkNotNullParameter(r9, "context");
            Intrinsics.checkNotNullParameter(r10, "data");
            Intrinsics.checkNotNullParameter(r13, "scene");
            Intent r16 = applyParams(new Intent(r9, SelectedMoreActivity.class), r10, r11, r12, r13, r15);
            if ((r9 instanceof Activity) == false) goto L5;
            Activity r17 = (Activity) r9;
        L6:
            if (r17 == null) goto L9;
            r17.startActivityForResult(r16, r14);
            return;
        L9:
            return;
        L5:
            r17 = null;
            goto L6
        }

        public final void startForResult(Context r11, Fragment r12, List<? extends SearchBaseInfo> r13, boolean r14, boolean r15, String r16, int r17, boolean r18) {
            Intrinsics.checkNotNullParameter(r11, "context");
            Intrinsics.checkNotNullParameter(r13, "data");
            Intrinsics.checkNotNullParameter(r16, "scene");
            Intent r0 = applyParams(new Intent(r11, SelectedMoreActivity.class), r13, r14, r15, r16, r18);
            if (r12 == null) goto L6;
            r12.startActivityForResult(r0, r17);
            return;
        }

        public static /* synthetic */ void startForResultInForseti$default(Companion r7, Context r8, Fragment r9, List r10, boolean r11, String r12, boolean r13, int r14, Object r15) {
            if ((r14 & 32) == 0) goto L5;
            boolean r6 = false;
        L6:
            r7.startForResultInForseti(r8, r9, r10, r11, r12, r6);
            return;
        L5:
            r6 = r13;
            goto L6
        }

        public static /* synthetic */ void startForResult$default(Companion r9, Context r10, List r11, boolean r12, boolean r13, String r14, int r15, boolean r16, int r17, Object r18) {
            if ((r17 & 64) == 0) goto L5;
            boolean r8 = false;
        L6:
            r9.startForResult(r10, r11, r12, r13, r14, r15, r8);
            return;
        L5:
            r8 = r16;
            goto L6
        }

        public static /* synthetic */ void startForResult$default(Companion r10, Context r11, Fragment r12, List r13, boolean r14, boolean r15, String r16, int r17, boolean r18, int r19, Object r20) {
            if ((r19 & 128) == 0) goto L5;
            boolean r9 = false;
        L6:
            r10.startForResult(r11, r12, r13, r14, r15, r16, r17, r9);
            return;
        L5:
            r9 = r18;
            goto L6
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0015\u0016B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/selectedview/SelectedMoreActivity$SimpleSelectedMoreAdapter;", "Lcom/ss/android/lark/base/adapter/LarkRecyclerViewBaseAdapter;", "Lcom/ss/android/lark/picker/base/widget/selectedview/SelectedMoreActivity$SimpleSelectedMoreAdapter$SelectedMemberViewHolder;", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "itemRemoveListener", "Lcom/ss/android/lark/picker/base/widget/selectedview/SelectedMoreActivity$SimpleSelectedMoreAdapter$OnSimpleItemRemoveListener;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "setOnItemRemoveListener", "listener", "OnSimpleItemRemoveListener", "SelectedMemberViewHolder", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class SimpleSelectedMoreAdapter extends LarkRecyclerViewBaseAdapter<SelectedMemberViewHolder, SearchBaseInfo> {
        private final Context context;
        private OnSimpleItemRemoveListener itemRemoveListener;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/selectedview/SelectedMoreActivity$SimpleSelectedMoreAdapter$OnSimpleItemRemoveListener;", "", "onItemRemove", "", "item", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
        public interface OnSimpleItemRemoveListener {
            void onItemRemove(SearchBaseInfo r1);
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/selectedview/SelectedMoreActivity$SimpleSelectedMoreAdapter$SelectedMemberViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "title", "Landroid/widget/TextView;", "avatar", "Lcom/larksuite/component/ui/avatar/v2/LarkAvatarView;", PickerReporterConstants.VALUE.CLICK.REMOVE, "getRemove", "()Landroid/view/View;", "bind", "", "item", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
        public static final class SelectedMemberViewHolder extends RecyclerView.ViewHolder {
            private final LarkAvatarView avatar;
            private final View remove;
            private final TextView title;

            public final View getRemove() {
                return this.remove;
            }

            public SelectedMemberViewHolder(View r2) {
                Intrinsics.checkNotNullParameter(r2, "itemView");
                super(r2);
                this.title = (TextView) r2.findViewById(2131391606);
                this.avatar = r2.findViewById(2131376019);
                this.remove = r2.findViewById(2131385848);
            }

            public final void bind(SearchBaseInfo r4) {
                Intrinsics.checkNotNullParameter(r4, "item");
                this.title.setText(r4.getTitle());
                this.avatar.setVisibility(0);
                if (AvatarHelperKt.bindExternalTargetAvatar(this.avatar, r4) == true) goto L6;
                LarkAvatarView r0 = this.avatar;
                a.a r1 = new a.a();
                r1.b(r4.getAvatarKey());
                r1.f(r4.getId());
                r0.j(new a(r1));
                return;
            }
        }

        public SimpleSelectedMoreAdapter(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            this.context = r2;
        }

        public static final /* synthetic */ OnSimpleItemRemoveListener access$getItemRemoveListener$p(SimpleSelectedMoreAdapter r0) {
            return r0.itemRemoveListener;
        }

        public final void setOnItemRemoveListener(OnSimpleItemRemoveListener r1) {
            this.itemRemoveListener = r1;
        }

        public void onBindViewHolder(SelectedMemberViewHolder r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "holder");
            final SearchBaseInfo r4 = (SearchBaseInfo) getItem(r3);
            Intrinsics.checkNotNull(r4);
            r2.bind(r4);
            r2.getRemove().setOnClickListener(new SelectedMoreActivity$SimpleSelectedMoreAdapter$onBindViewHolder$1(this, r4));
        }

        /* JADX INFO: renamed from: onCreateViewHolder, reason: collision with other method in class */
        public SelectedMemberViewHolder m3374onCreateViewHolder(ViewGroup r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "parent");
            View r5 = LayoutInflater.from(this.context).inflate(2131564504, r3, false);
            Intrinsics.checkNotNull(r5);
            return new SelectedMemberViewHolder(r5);
        }

        public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
            onBindViewHolder((SelectedMemberViewHolder) r1, r2);
        }

        public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
            return m3374onCreateViewHolder(r1, r2);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public void com_ss_android_lark_picker_base_widget_selectedview_SelectedMoreActivity__finish$___twin___() {
        super.finish();
    }

    public void com_ss_android_lark_picker_base_widget_selectedview_SelectedMoreActivity__onDestroy$___twin___() {
        super.onDestroy();
    }

    public void com_ss_android_lark_picker_base_widget_selectedview_SelectedMoreActivity__onStop$___twin___() {
        super/*androidx.appcompat.app.AppCompatActivity*/.onStop();
    }

    public void finish() {
        com_ss_android_lark_picker_base_widget_selectedview_SelectedMoreActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(this);
    }

    public void onCreate(Bundle r1) {
        com_ss_android_lark_picker_base_widget_selectedview_SelectedMoreActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(this, r1);
    }

    public void onDestroy() {
        com_ss_android_lark_picker_base_widget_selectedview_SelectedMoreActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_onDestroy(this);
    }

    public void onStop() {
        com_ss_android_lark_picker_base_widget_selectedview_SelectedMoreActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public SelectedMoreActivity() {
        this.selectedData = new ArrayList();
        this.removedData = new ArrayList();
    }

    public static View INVOKEVIRTUAL_com_ss_android_lark_picker_base_widget_selectedview_SelectedMoreActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == c.a) goto L7;
        c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static final /* synthetic */ LarkRecyclerViewBaseAdapter access$getAdapter$p(SelectedMoreActivity r0) {
        return r0.adapter;
    }

    public static final /* synthetic */ List access$getRemovedData$p(SelectedMoreActivity r0) {
        return r0.removedData;
    }

    public static final /* synthetic */ List access$getSelectedData$p(SelectedMoreActivity r0) {
        return r0.selectedData;
    }

    public static final /* synthetic */ boolean access$isUseResult$p(SelectedMoreActivity r0) {
        return r0.isUseResult;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void com_ss_android_lark_picker_base_widget_selectedview_SelectedMoreActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(SelectedMoreActivity r1) {
        r1.com_ss_android_lark_picker_base_widget_selectedview_SelectedMoreActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        INVOKEVIRTUAL_com_ss_android_lark_picker_base_widget_selectedview_SelectedMoreActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r1.getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void com_ss_android_lark_picker_base_widget_selectedview_SelectedMoreActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(SelectedMoreActivity r11) {
        r11.com_ss_android_lark_picker_base_widget_selectedview_SelectedMoreActivity__finish$___twin___();
        if ((r11 instanceof ChatWindowActivity) == false) goto L5;
        return;
    L5:
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(SelectedMoreActivity.class.getName()));
        long r3 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(r11);     // Catch: Throwable -> L50
        if (r6 != null) goto L10;
    L13:
        r5.put(r11, Long.valueOf(r3));     // Catch: Throwable -> L50
        monitor-exit(r5);     // Catch: Throwable -> L50
    L47:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
        return;
    L16:
        if (r11.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L20;
        r2.i("ActivityLancet", "quit !resume, current state = " + r11.getLifecycle().getCurrentState());     // Catch: Throwable -> L47
        return;
    L20:
        if (r11.isFinishing() == true) goto L24;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L47
        return;
    L24:
        if (ActivityStartBehavior.isInternalActivityConsumed(r11) == true) goto L28;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L47
        return;
    L28:
        if (ActivityLancet.isOnlyActivityInTask(r11) == true) goto L32;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L47
        return;
    L32:
        if (ActivityLancet.isExcludedActivity(r11) == false) goto L36;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L47
        return;
    L36:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L38;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L47
        return;
    L38:
        Intent r1 = r11.getPackageManager().getLaunchIntentForPackage(r11.getPackageName());     // Catch: Throwable -> L47
        if (r1 != null) goto L41;
        return;
    L41:
        r1.addFlags(268435456);     // Catch: Throwable -> L47
        r1.addFlags(2097152);     // Catch: Throwable -> L47
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + r11);     // Catch: Throwable -> L47
        r11.startActivity(r1);     // Catch: Throwable -> L44
        r11.overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L44
    L58:
        return;
    L44:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L47
        return;
    L10:
        if ((r3 - r6.longValue()) >= 800) goto L13;
        monitor-exit(r5);     // Catch: Throwable -> L50
        return;
    L50:
        th = move-exception;
        throw th;
    }

    public static void com_ss_android_lark_picker_base_widget_selectedview_SelectedMoreActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_onDestroy(SelectedMoreActivity r3) {
        if ((r3 instanceof FragmentActivity) == true) goto L5;
    L7:
        r3.com_ss_android_lark_picker_base_widget_selectedview_SelectedMoreActivity__onDestroy$___twin___();
        return;
    L5:
        if (WindowUtils.INSTANCE.isMainBotActivity(r3) == false) goto L7;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(r3);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(r3.getClass().getName()));
        goto L7
    }

    private final void updateRightTvBySelectedCount(int r4) {
        TextView r0 = null;
        if (r4 <= 0) goto L9;
        TextView r2 = this.titleBarRightTv;
        if (r2 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarRightTv");
    L8:
        r0.setText(UIHelper.mustacheFormat(2131892184, "select_count", String.valueOf(r4)));
        return;
    L7:
        r0 = r2;
        goto L8
    L9:
        TextView r5 = this.titleBarRightTv;
        if (r5 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarRightTv");
    L13:
        r0.setText(UIHelper.getString(2131891624));
        return;
    L12:
        r0 = r5;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void com_ss_android_lark_picker_base_widget_selectedview_SelectedMoreActivity__onCreate$___twin___(Bundle r8) {
        super.onCreate(r8);
        setContentView(2131568191);
        this.titleBar = findViewById(2131388807);
        this.moreList = findViewById(2131380315);
        Bundle r9 = getIntent().getExtras();
        LarkRecyclerViewBaseAdapter<? extends RecyclerView.ViewHolder, SearchBaseInfo> r0 = null;
        if (r9 == null) goto L5;
        Object r10 = r9.get("selected.data");
    L6:
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.Array<com.ss.android.lark.search.dto.info.SearchBaseInfo>");
        SearchBaseInfo[] r1 = (SearchBaseInfo[]) r10;
        CollectionsKt.addAll(this.selectedData, (Object[]) r10);
        List<SearchBaseInfo> r11 = this.selectedData;
        ExternalTargetAvatarProviderStore r2 = ExternalTargetAvatarProviderStore.INSTANCE;
        if ((r11 instanceof Collection) == true) goto L9;
    L11:
        Iterator<T> r12 = r11.iterator();
    L13:
        if (r12.hasNext() == false) goto L10;
        if (r2.requiresProvider((SearchBaseInfo) r12.next()) == false) goto L13;
        boolean r13 = true;
    L17:
        if (r13 == true) goto L19;
    L22:
        this.isEnableChatPreview = getIntent().getBooleanExtra(ENABLE_CHAT_PREVIEW, false);
        this.isUseResult = getIntent().getBooleanExtra(KEY_USE_RESULT, false);
        this.useSimpleSelectedMoreStyle = getIntent().getBooleanExtra(KEY_USE_DOU_BAO_STYLE, false);
        CommonTitleBar r14 = this.titleBar;
        if (r14 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r14 = null;
    L25:
        final String r3 = getString(2131891624);
        final int r6 = 2131105548;
        r14.addAction(new AnonymousClass3(this, r3, r6));
        CommonTitleBar r15 = this.titleBar;
        if (r15 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r15 = null;
    L28:
        this.titleBarRightTv = r15.getRightText();
        if (this.useSimpleSelectedMoreStyle == false) goto L31;
        LarkRecyclerViewBaseAdapter<? extends RecyclerView.ViewHolder, SearchBaseInfo> r16 = new SimpleSelectedMoreAdapter(this);
    L35:
        this.adapter = r16;
        RecyclerView r17 = this.moreList;
        if (r17 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("moreList");
        r17 = null;
    L38:
        RecyclerView.Adapter r4 = this.adapter;
        if (r4 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r4 = null;
    L41:
        r17.setAdapter(r4);
        RecyclerView r18 = this.moreList;
        if (r18 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("moreList");
        r18 = null;
    L44:
        r18.setLayoutManager(new LinearLayoutManager(this, 1, false));
        final Function1<SearchBaseInfo, Unit> r19 = new SelectedMoreActivity$onCreate$onRemoveListener$1(this);
        LarkRecyclerViewBaseAdapter<? extends RecyclerView.ViewHolder, SearchBaseInfo> r5 = this.adapter;
        if (r5 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r5 = null;
    L48:
        if ((r5 instanceof SelectedMoreAdapter) == false) goto L51;
        ((SelectedMoreAdapter) r5).setOnItemRemoveListener(new AnonymousClass5(r19));
    L53:
        LarkRecyclerViewBaseAdapter<? extends RecyclerView.ViewHolder, SearchBaseInfo> r20 = this.adapter;
        if (r20 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L57:
        r0.addAll(this.selectedData);
        updateRightTvBySelectedCount(this.selectedData.size());
        return;
    L56:
        r0 = r20;
        goto L57
    L51:
        if ((r5 instanceof SimpleSelectedMoreAdapter) == false) goto L53;
        ((SimpleSelectedMoreAdapter) r5).setOnItemRemoveListener(new AnonymousClass6(r19));
        goto L53
    L31:
        SelectedMoreAdapter r21 = new SelectedMoreAdapter(this);
        r21.setIsEnableChatPreview(this.isEnableChatPreview);
        String r7 = getIntent().getStringExtra(KEY_SCENE);
        if (r7 != null) goto L34;
        r7 = "";
    L34:
        r21.setScene(r7);
        r16 = r21;
        goto L35
    L19:
        if (ExternalTargetAvatarProviderStore.INSTANCE.hasProvider() == true) goto L22;
        Log.w("LarkSearch.SearchWidget.SelectedMoreActivity", "finish selected more: external target avatar provider unavailable");
        finish();
        return;
    L10:
        r13 = false;
        goto L17
    L9:
        if (r11.isEmpty() == false) goto L11;
    L5:
        r10 = null;
        goto L6
    }

    public static final /* synthetic */ void access$updateRightTvBySelectedCount(SelectedMoreActivity r0, int r1) {
        r0.updateRightTvBySelectedCount(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void com_ss_android_lark_picker_base_widget_selectedview_SelectedMoreActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(SelectedMoreActivity r1, Bundle r2) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(r1.getTheme());     // Catch: Throwable -> L10
    L6:
        if (f.f(r1) == false) goto L8;
        f.c(r1.getTheme());     // Catch: Throwable -> L10
    L8:
        r1.com_ss_android_lark_picker_base_widget_selectedview_SelectedMoreActivity__onCreate$___twin___(r2);
    }
}
