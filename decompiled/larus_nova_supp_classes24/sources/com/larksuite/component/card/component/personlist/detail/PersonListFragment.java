package com.larksuite.component.card.component.personlist.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.card.component.personlist.PersonInfo;
import com.larksuite.component.card.component.personlist.avatar.SimpleUserLoader;
import com.larksuite.component.card.utils.k;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0019H\u0002J\u0018\u0010\u001c\u001a\u00020\u00192\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eH\u0002J\b\u0010 \u001a\u00020\u0019H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/larksuite/component/card/component/personlist/detail/PersonListFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "<init>", "()V", "personListRecyclerView", "Lcom/ss/android/lark/widget/recyclerview/CommonRecyclerView;", "personListAdapter", "Lcom/larksuite/component/card/component/personlist/detail/PersonListAdapter;", "titleBar", "Lcom/ss/android/lark/ui/CommonTitleBar;", "getTitleBar", "()Lcom/ss/android/lark/ui/CommonTitleBar;", "setTitleBar", "(Lcom/ss/android/lark/ui/CommonTitleBar;)V", "canLoadMore", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "initViews", "loadAvatarIfNeed", "personList", "Ljava/util/ArrayList;", "Lcom/larksuite/component/card/component/personlist/PersonInfo;", "initListener", "Companion", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public class PersonListFragment extends BaseFragment {
    public CommonRecyclerView d;
    public PersonListAdapter e;
    public CommonTitleBar f;

    public static final class a {
    }

    static {
    }

    public PersonListFragment() {
    }

    public static final /* synthetic */ String S90(PersonListFragment r0) {
        return ((BaseFragment) r0).PARENT_TAG;
    }

    public void onViewCreated(View r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        super.onViewCreated(r9, r10);
        LinearLayoutManager r11 = new LinearLayoutManager(requireContext(), 1, false);
        RecyclerView r12 = this.d;
        RecyclerView r2 = null;
        if (r12 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("personListRecyclerView");
        r12 = null;
    L5:
        r12.setLayoutManager(r11);
        this.e = new PersonListAdapter();
        Bundle r13 = getArguments();
        if (r13 == null) goto L47;
        ArrayList r14 = r13.getParcelableArrayList("person_list");
        PersonListAdapter r4 = this.e;
        if (r4 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("personListAdapter");
        r4 = null;
    L10:
        r4.getClass();
        StringBuilder r5 = new StringBuilder("setDataList newData:");
        if (r14 == null) goto L13;
        Integer r6 = Integer.valueOf(r14.size());
    L14:
        r5.append(r6);
        r5.append(", ");
        r5.append(((ArrayList) r4.a).size());
        Log.i("PersonListAdapter", r5.toString());
        if (r14 != null) goto L17;
    L20:
        boolean r7 = true;
    L21:
        if (r7 == true) goto L24;
        ((ArrayList) r4.a).clear();
        int r8 = ((ArrayList) r4.a).size();
        ((ArrayList) r4.a).addAll(r14);
        r4.notifyItemRangeInserted(r8, r14.size());
    L24:
        if (r14 == null) goto L47;
        ArrayList r15 = new ArrayList();
        Iterator r16 = r14.iterator();
    L27:
        if (r16.hasNext() == false) goto L42;
        Object r17 = r16.next();
        PersonInfo r19 = (PersonInfo) r17;
        String r20 = r19.getAvatarKey();
        if (r20 != null) goto L31;
    L34:
        boolean r21 = true;
    L35:
        if (r21 == true) goto L37;
    L39:
        boolean r22 = false;
    L40:
        if (r22 == false) goto L27;
        r15.add(r17);
        goto L27
    L37:
        if (k.b(r19.getId()) == false) goto L39;
        r22 = true;
        goto L40
    L31:
        if (r20.length() == 0) goto L34;
        r21 = false;
        goto L35
    L42:
        ArrayList r23 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator r0 = r15.iterator();
    L44:
        if (r0.hasNext() == false) goto L46;
        r23.add(((PersonInfo) r0.next()).getId());
        goto L44
    L46:
        Lazy<SimpleUserLoader> r1 = SimpleUserLoader.d;
        SimpleUserLoader.a.a().b(r23, new wy7.a(this));
        goto L47
    L17:
        if (r14.isEmpty() == true) goto L20;
        r7 = false;
        goto L21
    L13:
        r6 = null;
    L47:
        CommonTitleBar r24 = this.f;
        if (r24 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r24 = null;
    L51:
        r24.setTitle(UIUtils.getString(getContext(), 2131890882));
        RecyclerView r25 = this.d;
        if (r25 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("personListRecyclerView");
        r25 = null;
    L54:
        PersonListAdapter r3 = this.e;
        if (r3 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("personListAdapter");
        r3 = null;
    L57:
        r25.setAdapter(r3);
        PersonListAdapter r26 = this.e;
        if (r26 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("personListAdapter");
        r26 = null;
    L60:
        com.larksuite.component.card.component.personlist.detail.a r110 = new com.larksuite.component.card.component.personlist.detail.a(this);
        r26.getClass();
        Intrinsics.checkNotNullParameter(r110, "itemClickListener");
        r26.b = r110;
        RecyclerView r27 = this.d;
        if (r27 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("personListRecyclerView");
    L64:
        r2.addOnScrollListener(new PersonListFragment$initListener$2(this));
        return;
    L63:
        r2 = r27;
        goto L64
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131561175, r3, false);
        this.d = r5.findViewById(2131384986);
        CommonTitleBar r6 = r5.findViewById(2131388807);
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        this.f = r6;
        return r5;
    }
}
