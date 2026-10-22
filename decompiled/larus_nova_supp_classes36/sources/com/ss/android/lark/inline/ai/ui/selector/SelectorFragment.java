package com.ss.android.lark.inline.ai.ui.selector;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.inline.ai.api.MentionType;
import com.ss.android.lark.picker.config.SearcherConfig;
import com.ss.android.lark.picker.statistics.PickerStatistics;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.ui.CommonTitleBar;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\fH\u0002J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\n\u0010\u001b\u001a\u0004\u0018\u00010\fH\u0002J\n\u0010\u001c\u001a\u0004\u0018\u00010\fH\u0002J\n\u0010\u001d\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020#2\u0006\u0010 \u001a\u00020!H\u0002J\f\u0010$\u001a\u00020\u0014*\u00020%H\u0002J\u0010\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\bH\u0002J\b\u0010(\u001a\u00020\u0014H\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/ss/android/lark/inline/ai/ui/selector/SelectorFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "mentionType", "", "<init>", "(Ljava/lang/String;)V", "chatterInfoList", "", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "scene", "Lcom/ss/android/lark/picker/statistics/PickerStatistics$Scene;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "initView", "rootView", "getTitle", "resources", "Landroid/content/res/Resources;", "getPicker", "getDefaultPicker", "getNavPicker", "getNavPickerConfig", "Lcom/ss/android/lark/picker/config/NavPickerConfig;", "activity", "Landroidx/fragment/app/FragmentActivity;", "getPickerConfig", "Lcom/ss/android/lark/picker/config/PickerConfig;", "getDefaultConfig", "Lcom/ss/android/lark/picker/config/SearcherConfig;", "selectedDocumentHandler", "info", "selectedUserHandler", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class SelectorFragment extends BaseFragment {
    public static final /* synthetic */ int g = 0;
    public final String d;
    public List<SearchBaseInfo> e;
    public final PickerStatistics.Scene f;

    public SelectorFragment(String r1) {
        this.d = r1;
        this.f = PickerStatistics.Scene.CcmInlineAI;
    }

    public final String T90(Resources r3) {
        if (TextUtils.equals(this.d, MentionType.DOCUMENT.getValue()) == false) goto L6;
        String r4 = r3.getString(2131889159);
        Intrinsics.checkNotNull(r4);
        return r4;
    L6:
        if (TextUtils.equals(this.d, MentionType.USER.getValue()) == false) goto L8;
        String r5 = r3.getString(2131887572);
        Intrinsics.checkNotNull(r5);
        return r5;
    L8:
        return "";
    }

    public static final void S90(SelectorFragment r4, SearcherConfig r5) {
        if (TextUtils.equals(r4.d, MentionType.DOCUMENT.getValue()) == false) goto L6;
        SearcherConfig.doc$default(r5, false, SelectorFragment$getDefaultConfig$1.INSTANCE, 1, null);
        SearcherConfig.wiki$default(r5, false, SelectorFragment$getDefaultConfig$2.INSTANCE, 1, null);
        return;
    L6:
        if (TextUtils.equals(r4.d, MentionType.USER.getValue()) == false) goto L10;
        SearcherConfig.chatter$default(r5, false, SelectorFragment$getDefaultConfig$3.INSTANCE, 1, null);
        return;
    }

    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        CommonTitleBar r0 = r4.findViewById(2131388928);
        if (Intrinsics.areEqual(this.d, MentionType.USER.getValue()) == false) goto L5;
        r0.setVisibility(8);
    L6:
        FragmentActivity r1 = getActivity();
        if (r1 == null) goto L10;
        r1.findViewById(2131388928).setLeftClickListener(new a(r1));
        r0.post(new b(r1, r4, this));
        return;
    L10:
        return;
    L5:
        r0.setVisibility(0);
        r0.setTitle(T90(r4.getResources()));
        goto L6
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131561247, r3, false);
    }
}
