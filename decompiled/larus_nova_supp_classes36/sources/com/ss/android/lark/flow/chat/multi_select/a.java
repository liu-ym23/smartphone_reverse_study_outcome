package com.ss.android.lark.flow.chat.multi_select;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.larksuite.framework.utils.UIUtils;
import com.larksuite.framework.utils.f0;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.biz.im.api.extension.message.MultiSelectContext;
import com.ss.android.lark.biz.im.api.extension.message.i;
import com.ss.android.lark.biz.im.api.extension.message.k;
import com.ss.android.lark.flow.chat.page.flow.plugin.select.f;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements k {

    /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.multi_select.a$a, reason: collision with other inner class name */
    public static final class C0030a {
    }

    public final class b implements i {
        public final MultiSelectContext a;

        /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.multi_select.a$b$a, reason: collision with other inner class name */
        public static final class ViewOnClickListenerC0031a implements View.OnClickListener {
            public final /* synthetic */ b a;
            public final /* synthetic */ List<String> b;

            public ViewOnClickListenerC0031a(b r1, List<String> r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r5) {
                final b r6 = this.a;
                List<String> r0 = this.b;
                r6.getClass();
                Log.i("DeleteMultiSelect", "multi delete msg: " + f0.d(r0));
                ImSdkService.f().k7(r0, (IGetDataCallback) r6.a.b().wrapAndAddCallback(new UIGetDataCallback(new DeleteMultiSelectProvider$DeleteMultiSelectAction$multiDelete$callback$1(r6))));
            }
        }

        public final int getId() {
            return 60;
        }

        public final void onClick() {
            List r0 = this.a.e();
            Context r1 = this.a.getContext();
            ViewOnClickListenerC0031a r2 = new ViewOnClickListenerC0031a(this, r0);
            com.larksuite.component.ui.dialog.i r3 = new com.larksuite.component.ui.dialog.i(r1);
            String r4 = UIHelper.getString(2131891552);
            String r5 = UIHelper.getString(2131892334);
            int r6 = r4.indexOf(r5);
            int r7 = r5.length();
            SpannableString r8 = new SpannableString(r4);
            if (r6 < 0) goto L5;
            int r9 = r7 + r6;
            r8.setSpan(new ForegroundColorSpan(UIHelper.getColor(2131106622)), r6, r9, 17);
            r8.setSpan(new StyleSpan(1), r6, r9, 17);
        L6:
            r3.k(r8);
            ((com.larksuite.component.ui.dialog.d) r3).c.titleLineCount(2);
            r3.n(new CharSequence[]{UIUtils.getString(r1, 2131891662)});
            ((com.larksuite.component.ui.dialog.b) r3).f = new h7b.c(r2);
            ((com.larksuite.component.ui.dialog.b) r3).g.itemTextColor(2131102093);
            UDBaseDialogBuilder.ActionBuilder r10 = new UDBaseDialogBuilder.ActionBuilder();
            r10.actionResId(com.larksuite.component.ui.dialog.d.e.get(2131378548, 2131378548));
            r10.text(2131891541);
            r10.text(null);
            r10.textSize(0);
            r10.textColorRes(2131106622);
            r10.textColor(0);
            r10.bgColorRes(0);
            r10.bgDrawableRes(0);
            r10.onClickListener(null);
            ((com.larksuite.component.ui.dialog.d) r3).c.addActionButton(r10);
            r3.i();
            return;
        L5:
            Log.i("ActionUtils", "getDeleteMessageTips: span index == -1!");
            goto L6
        }

        public b(f r2) {
            Intrinsics.checkNotNullParameter(r2, "multiSelectContext");
            this.a = r2;
        }
    }

    static {
    }

    public a() {
    }

    public final boolean b(f r2) {
        Intrinsics.checkNotNullParameter(r2, "multiSelectContext");
        return true;
    }

    public final Collection<MultiSelectContext.Page> c() {
        return CollectionsKt.listOf(MultiSelectContext.Page.CHAT_WINDOW);
    }

    public final i a(f r1, BaseFragment r2) {
        Intrinsics.checkNotNullParameter(r1, "multiSelectContext");
        return new b(r1);
    }
}
