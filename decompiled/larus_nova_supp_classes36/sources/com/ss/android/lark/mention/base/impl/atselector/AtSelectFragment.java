package com.ss.android.lark.mention.base.impl.atselector;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import butterknife.ButterKnife;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.appreciablelib.AppreciableKit;
import com.ss.android.lark.base.fragment.BaseForsetiFragment;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.dto.usergroup.UserGroupEntity;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.mention.base.impl.atselector.view.AtView;
import com.suite.lark.component.navroute.forseti.f;
import com.suite.lark.component.navroute.forseti.g;
import java.io.Serializable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class AtSelectFragment extends BaseForsetiFragment {
    public static final /* synthetic */ int l = 0;
    public AtPresenter g;
    public String h;
    public View i;
    public int j;
    public final a k;

    public class a implements AtView.e {
        public final /* synthetic */ AtSelectFragment a;

        @Override // com.ss.android.lark.mention.base.impl.atselector.view.AtView.e
        public final void y() {
            this.a.S90();
        }

        public a(AtSelectFragment r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.mention.base.impl.atselector.view.AtView.e
        public final void a(AtView r2) {
            ButterKnife.bind(r2, this.a.i);
        }

        @Override // com.ss.android.lark.mention.base.impl.atselector.view.AtView.e
        public final void b(com.ss.android.lark.mention.base.impl.atselector.bean.d r5) {
            List<? extends ChatChatter> r0 = r5.a;
            List<UserGroupEntity> r6 = r5.b;
            StringBuilder r1 = new StringBuilder("finishActivityWithSelectMembers, chatters size: ");
            int r2 = 0;
            if (r0 == null) goto L5;
            int r3 = r0.size();
        L6:
            r1.append(r3);
            r1.append(", userGroups size: ");
            if (r6 == null) goto L9;
            r2 = r6.size();
        L9:
            r1.append(r2);
            Log.i("AtSelectActivity", r1.toString());
            if (CollectionUtils.isNotEmpty(r0) == true) goto L14;
            if (CollectionUtils.isNotEmpty(r6) == true) goto L14;
        L16:
            Bundle r4 = new Bundle();
            r4.putSerializable("chatters_info", (Serializable) r0);
            r4.putSerializable("user_groups_info", (Serializable) r6);
            AtSelectFragment r7 = this.a;
            r7.getClass();
            Intrinsics.checkNotNullParameter(r4, "result");
            g r8 = f.b(r7);
            if (r8 == null) goto L19;
            r8.c(-1, r4);
            return;
        L19:
            FragmentActivity r9 = r7.getActivity();
            if (r9 == null) goto L22;
            r9.setResult(-1, new Intent().putExtras(r4));
        L22:
            FragmentActivity r10 = r7.getActivity();
            if (r10 == null) goto L27;
            r10.finish();
            return;
        L27:
            return;
        L14:
            if (TextUtils.isEmpty(this.a.h) == true) goto L16;
            String r11 = com.ss.android.lark.mention.base.impl.statistics.a.a;
            com.ss.android.lark.mention.base.impl.statistics.a.b(r0.size(), this.a.h);
            goto L16
        L5:
            r3 = 0;
            goto L6
        }

        @Override // com.ss.android.lark.mention.base.impl.atselector.view.AtView.e
        public final void showToast(String r2) {
            LKUIToast.show(this.a.requireContext(), r2);
        }
    }

    public final void onDestroy() {
        AtPresenter r0 = this.g;
        if (r0 == null) goto L5;
        r0.destroy();
    L5:
        boolean r1 = crb.a.a;
        Log.e("AtSelectMonitor", "clearRecordMapOnDestroy");
        crb.a.b.clear();
        super/*com.ss.android.lark.base.fragment.BaseFragment*/.onDestroy();
    }

    public AtSelectFragment() {
        this.k = new a(this);
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        if (com.ss.android.lark.mention.base.impl.statistics.a.b == true) goto L6;
        AppreciableKit.Companion.getInstance().spanEnd(com.ss.android.lark.mention.base.impl.statistics.a.a, "first_render");
        com.ss.android.lark.mention.base.impl.statistics.a.b = true;
        return;
    }

    public final void onViewCreated(View r1, Bundle r2) {
        super/*com.ss.android.lark.base.fragment.BaseFragment*/.onViewCreated(r1, r2);
        qqb.c.d("AtSelectActivity onCreate", new c(this));
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        int r6 = hashCode();
        this.j = r6;
        boolean r0 = crb.a.a;
        crb.a.b(r6, SystemClock.uptimeMillis());
        fsb.f.b().i("setContentView");
        this.i = r3.inflate(2131558457, r4, false);
        fsb.f.b().h("setContentView");
        BaseForsetiFragment.T90(this);
        return this.i;
    }
}
