package amb;

import android.content.ClipData;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import at5.f;
import com.bytedance.ee.larkwebview.base.LarkWebView;
import com.bytedance.ee.util.ui.n;
import com.bytedance.supervisor.token.Token;
import com.ss.android.lark.inline.ai.ui.richtext.RichtextPreviewWebview;
import com.ss.android.lark.inline.ai.ui.richtext.selection.AISelectionData;
import com.ss.android.lark.inline.ai.ui.richtext.selection.Position;
import com.ss.android.lark.inline.ai.ui.richtext.selection.SelectionMenuItem;
import com.ss.android.lark.log.Log;
import com.suite.lark.emm.impl.SCClipboardProvider;
import com.suite.lark.emm.impl.clipboard.SCClipboardScene;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import wlb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements f<AISelectionData, LarkWebView> {
    public final e a;
    public ActionMode b;
    public AISelectionData c;
    public final ActionMode.Callback d;

    public final class a extends ActionMode.Callback2 implements ActionMode.Callback {
        public final /* synthetic */ ActionMode.Callback a;
        public final /* synthetic */ d b;

        @Override // android.view.ActionMode.Callback
        public final boolean onActionItemClicked(ActionMode r2, MenuItem r3) {
            return this.a.onActionItemClicked(r2, r3);
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onCreateActionMode(ActionMode r2, Menu r3) {
            return this.a.onCreateActionMode(r2, r3);
        }

        @Override // android.view.ActionMode.Callback
        public final void onDestroyActionMode(ActionMode r2) {
            this.a.onDestroyActionMode(r2);
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onPrepareActionMode(ActionMode r2, Menu r3) {
            return this.a.onPrepareActionMode(r2, r3);
        }

        public a(d r2, b r3) {
            Intrinsics.checkNotNullParameter(r3, "callback");
            this.b = r2;
            this.a = r3;
        }

        @Override // android.view.ActionMode.Callback2
        public final void onGetContentRect(ActionMode r5, View r6, Rect r7) {
            StringBuilder r8 = new StringBuilder("aiSelectionData.position : ");
            AISelectionData r9 = this.b.c;
            if (r9 == null) goto L5;
            Position r10 = r9.getPosition();
        L6:
            r8.append(r10);
            Log.i("RichtextPreviewBridge", r8.toString());
            AISelectionData r11 = this.b.c;
            if (r11 == null) goto L29;
            Position r12 = r11.getPosition();
            if (r12 == null) goto L30;
            d r13 = this.b;
            if (r7 == null) goto L31;
            Float r1 = r12.getLeft();
            float r2 = 0.0f;
            if (r1 == null) goto L15;
            float r3 = r1.floatValue();
        L16:
            r13.getClass();
            int r14 = n.c(r3);
            Float r4 = r12.getTop();
            if (r4 == null) goto L19;
            float r15 = r4.floatValue();
        L20:
            int r16 = n.c(r15);
            Float r17 = r12.getRight();
            if (r17 == null) goto L23;
            float r18 = r17.floatValue();
        L24:
            int r19 = n.c(r18);
            Float r20 = r12.getBottom();
            if (r20 == null) goto L27;
            r2 = r20.floatValue();
        L27:
            r7.set(new Rect(r14, r16, r19, n.c(r2)));
            return;
        L23:
            r18 = 0.0f;
            goto L24
        L19:
            r15 = 0.0f;
            goto L20
        L15:
            r3 = 0.0f;
            goto L16
        L31:
            return;
        L30:
            return;
        L29:
            return;
        L5:
            r10 = null;
            goto L6
        }
    }

    public final class b implements ActionMode.Callback {
        public final /* synthetic */ d a;

        public b(d r1) {
            this.a = r1;
        }

        @Override // android.view.ActionMode.Callback
        public final void onDestroyActionMode(ActionMode r4) {
            StringBuilder r0 = new StringBuilder("onDestroyActionMode actionMode: ");
            ActionMode r1 = this.a.b;
            if (r1 == null) goto L5;
            Integer r2 = Integer.valueOf(r1.hashCode());
        L6:
            r0.append(r2);
            r0.append(", mode: ");
            if (r4 == null) goto L9;
            Integer r3 = Integer.valueOf(r4.hashCode());
        L10:
            r0.append(r3);
            Log.i("RichtextPreviewBridge", r0.toString());
            ActionMode r5 = this.a.b;
            if (r5 == null) goto L15;
            if (r5 == r4) goto L15;
            if (r5 == null) goto L15;
            r5.finish();
        L15:
            this.a.b = null;
            return;
        L9:
            r3 = null;
            goto L10
        L5:
            r2 = null;
            goto L6
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onActionItemClicked(ActionMode r5, MenuItem r6) {
            StringBuilder r0 = new StringBuilder("onActionItemClicked actionMode: ");
            ActionMode r1 = this.a.b;
            String r2 = null;
            if (r1 == null) goto L5;
            Integer r3 = Integer.valueOf(r1.hashCode());
        L6:
            r0.append(r3);
            r0.append(", mode: ");
            if (r5 == null) goto L9;
            Integer r7 = Integer.valueOf(r5.hashCode());
        L10:
            r0.append(r7);
            r0.append(", title: ");
            if (r6 == null) goto L13;
            CharSequence r8 = r6.getTitle();
        L14:
            r0.append(r8);
            r0.append(", itemId: ");
            if (r6 == null) goto L17;
            Integer r9 = Integer.valueOf(r6.getItemId());
        L18:
            r0.append(r9);
            Log.i("RichtextPreviewBridge", r0.toString());
            int r10 = com.suite.lark.emm.impl.a.a;
            com.suite.lark.emm.impl.a.a.a().getClass();
            boc.b r11 = SCClipboardProvider.a();
            e r4 = this.a.a;
            if (r4 == null) goto L22;
            String r12 = r4.g();
            if (r12 == null) goto L22;
        L23:
            Log.i("RichtextPreviewBridge", "onActionItemClicked encryptId: ".concat(r12));
            if (TextUtils.isEmpty(r12) == false) goto L26;
            SCClipboardScene r13 = SCClipboardScene.SCENE_DEFAULT;
        L27:
            r11.Q0(r13);
            AISelectionData r14 = this.a.c;
            if (r14 == null) goto L30;
            String r15 = r14.getText();
        L31:
            AISelectionData r16 = this.a.c;
            if (r16 == null) goto L34;
            r2 = r16.getHtmlText();
        L34:
            ClipData r17 = ClipData.newHtmlText("", r15, r2);
            Intrinsics.checkNotNull(r17);
            r11.M0(r17, new Token("LARK-PSDA-android_inlineai_roadster_selection"));
            this.a.b();
            return true;
        L30:
            r15 = null;
            goto L31
        L26:
            r13 = SCClipboardScene.SCENE_ENCRYPT;
            r13.setParam(r12);
        L22:
            r12 = "";
            goto L23
        L17:
            r9 = null;
            goto L18
        L13:
            r8 = null;
            goto L14
        L9:
            r7 = null;
            goto L10
        L5:
            r3 = null;
            goto L6
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onCreateActionMode(ActionMode r4, Menu r5) {
            StringBuilder r0 = new StringBuilder("onCreateActionMode actionMode: ");
            ActionMode r1 = this.a.b;
            Integer r2 = null;
            if (r1 == null) goto L5;
            Integer r3 = Integer.valueOf(r1.hashCode());
        L6:
            r0.append(r3);
            r0.append(", mode: ");
            if (r4 == null) goto L9;
            Integer r6 = Integer.valueOf(r4.hashCode());
        L10:
            r0.append(r6);
            r0.append(", menu: ");
            if (r5 == null) goto L13;
            r2 = Integer.valueOf(r5.hashCode());
        L13:
            r0.append(r2);
            Log.i("RichtextPreviewBridge", r0.toString());
            ActionMode r7 = this.a.b;
            if (r7 != null) goto L16;
        L20:
            if (r5 == null) goto L22;
            r5.clear();
        L22:
            this.a.b = r4;
            return true;
        L16:
            if (Intrinsics.areEqual(r7, r4) == true) goto L20;
            ActionMode r8 = this.a.b;
            if (r8 == null) goto L20;
            r8.finish();
            goto L20
        L9:
            r6 = null;
            goto L10
        L5:
            r3 = null;
            goto L6
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onPrepareActionMode(ActionMode r6, Menu r7) {
            AISelectionData r0 = this.a.c;
            if (r0 == null) goto L13;
            ArrayList<SelectionMenuItem> r1 = r0.getSelectionMenus();
            if (r1 == null) goto L13;
            Iterator<SelectionMenuItem> r2 = r1.iterator();
            int r3 = 0;
        L8:
            if (r2.hasNext() == false) goto L13;
            SelectionMenuItem r4 = r2.next();
            if (r7 == null) goto L12;
            r7.add(769711401, 0, r3, r4.getText());
        L12:
            r3 = r3 + 1;
        L13:
            StringBuilder r5 = new StringBuilder("onPrepareActionMode actionMode: ");
            ActionMode r8 = this.a.b;
            Integer r9 = null;
            if (r8 == null) goto L16;
            Integer r10 = Integer.valueOf(r8.hashCode());
        L17:
            r5.append(r10);
            r5.append(", mode: ");
            if (r6 == null) goto L20;
            Integer r11 = Integer.valueOf(r6.hashCode());
        L21:
            r5.append(r11);
            r5.append(", menu: ");
            if (r7 == null) goto L24;
            Integer r12 = Integer.valueOf(r7.hashCode());
        L25:
            r5.append(r12);
            r5.append(", menu.size: ");
            if (r7 == null) goto L28;
            r9 = Integer.valueOf(r7.size());
        L28:
            r5.append(r9);
            Log.i("RichtextPreviewBridge", r5.toString());
            return true;
        L24:
            r12 = null;
            goto L25
        L20:
            r11 = null;
            goto L21
        L16:
            r10 = null;
            goto L17
        }
    }

    public static final class c {
    }

    static {
    }

    public final boolean shouldRunInUIThread() {
        return true;
    }

    public final void b() {
        if (this.b == null) goto L9;
        Log.i("RichtextPreviewBridge", "finishActionMode");
        ActionMode r0 = this.b;
        if (r0 == null) goto L7;
        r0.finish();
    L7:
        this.b = null;
        return;
    }

    public d(e r2) {
        this.a = r2;
        if (Build.VERSION.SDK_INT < 23) goto L5;
        ActionMode.Callback r3 = new a(this, new b(this));
    L6:
        this.d = r3;
        return;
    L5:
        r3 = new b(this);
        goto L6
    }

    public final void a(Object r1, at5.d r2, String r3, LarkWebView r4) {
        AISelectionData r5 = (AISelectionData) r1;
        Intrinsics.checkNotNullParameter(r2, "callback");
        Log.i("RichtextPreviewBridge", "AISelectionShowMenuHandler : " + r5);
        if ((r4 instanceof RichtextPreviewWebview) == false) goto L10;
        this.c = r5;
        RichtextPreviewWebview r6 = (RichtextPreviewWebview) r4;
        b();
        if (Build.VERSION.SDK_INT < 23) goto L7;
        ActionMode r7 = r6.o(this.d, 1);
    L8:
        this.b = r7;
        return;
    L7:
        r7 = r6.startActionMode(this.d);
        goto L8
    }
}
