package com.larksuite.component.card.component.personlist;

import android.content.Context;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentActivity;
import com.google.gson.Gson;
import com.larksuite.component.card.component.personlist.avatar.SimpleUserLoader;
import com.larksuite.component.card.protocol.context.ICardDependency;
import com.larksuite.component.card.utils.k;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.event.LynxEventDetail;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001c\u001d\u001eB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\bH\u0014J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0012\u0010\u0010\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010\u0013\u001a\u00020\nH\u0016J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001bH\u0002¨\u0006\u001f"}, d2 = {"Lcom/larksuite/component/card/component/personlist/PersonListLynxUI;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Lcom/larksuite/component/card/component/personlist/PersonListTextView;", "context", "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "createView", "Landroid/content/Context;", "updateExtraData", "", "extraData", "", "setContent", "props", "Lcom/lynx/react/bridge/ReadableMap;", "loadAvatarIfNeed", "personListProp", "Lcom/larksuite/component/card/component/personlist/PersonListProps;", "initLongClickListener", "dispatchEvent", "", "event", "Lcom/lynx/tasm/event/LynxEventDetail;", "enableCopy", "textView", "cardShareData", "Lcom/larksuite/component/card/cardcontainer/UniversalCardShareData;", "Companion", "ClickMoreListener", "ClickPersonListener", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public class PersonListLynxUI extends LynxUI<PersonListTextView> {
    public static final /* synthetic */ int a = 0;

    public static final class a implements com.larksuite.component.card.component.personlist.a {
        public final rcc.a a;

        public a() {
            this.a = new rcc.a();
        }

        @Override // com.larksuite.component.card.component.personlist.a
        public final void a(FragmentActivity r2, List r3) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "personList");
            if (this.a.a() == false) goto L6;
            Log.e("CardPersonListLynxUI", "click more check isDuplicate: " + r3.hashCode());
            return;
        L6:
            wy7.b.b(r2, r3);
        }
    }

    public static final class b implements com.larksuite.component.card.component.personlist.b {
        public final ShadowNode a;
        public final ICardDependency b;
        public final rcc.a c;

        @Override // com.larksuite.component.card.component.personlist.b
        public final void a(String r4) {
            if (this.c.a() == false) goto L7;
            Log.e("CardPersonListLynxUI", "click person check isDuplicate: " + r4);
            return;
        L7:
            if (TextUtils.isEmpty(r4) == false) goto L10;
            Log.e("CardPersonListLynxUI", "userId is empty");
            return;
        L10:
            ICardDependency r0 = this.b;
            if (r0 == null) goto L14;
            if (r4 == null) goto L18;
            r0.openProfilePage(this.a.getContext(), r4, "");
            return;
        L18:
            return;
        L14:
            yy7.a r1 = ty7.a.a();
            if (r1 == null) goto L20;
            r1.showProfile(this.a.getContext(), r4);
            return;
        }

        public b(ShadowNode r2, ICardDependency r3) {
            Intrinsics.checkNotNullParameter(r2, "node");
            this.a = r2;
            this.b = r3;
            this.c = new rcc.a();
        }
    }

    public static final class c {
    }

    static {
    }

    public PersonListLynxUI(LynxContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    public static final /* synthetic */ View M(PersonListLynxUI r0) {
        return ((LynxUI) r0).mView;
    }

    public final View createView(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        AppCompatTextView r0 = new PersonListTextView(r3);
        r0.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
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

    @LynxProp(name = "props")
    public final void setContent(ReadableMap r7) {
        Intrinsics.checkNotNullParameter(r7, "props");
        TraceEvent.beginSection("PersonListLynxUI.setContent");
        Integer r2 = null;
        Gson r3 = com.larksuite.component.card.component.g.a;     // Catch: Throwable -> L5
        PersonListProps r8 = (PersonListProps) com.larksuite.component.card.component.g.c(r7, PersonListProps.class);     // Catch: Throwable -> L5
    L7:
        if (r8 != null) goto L10;
        Log.e("CardPersonListLynxUI", "setContent fail, content is empty");
        return;
    L10:
        Integer r0 = r8.getLines();
        if (r0 != null) goto L13;
    L20:
        ((PersonListTextView) ((LynxUI) this).mView).setMaxLines(LKUIToast.DURATION_MAX);
    L21:
        TextPaint r1 = ((PersonListTextView) ((LynxUI) this).mView).getPaint();
        g.a.getClass();
        r1.setTextSize(g.h(r8));
        ((PersonListTextView) ((LynxUI) this).mView).getPaint().setColor(g.g(r8));
        ((PersonListTextView) ((LynxUI) this).mView).setOnLongClickListener(new d(this));
        if (r8.getShowAvatar() == false) goto L40;
        ArrayList r4 = new ArrayList();
        Iterator<T> r9 = r8.getPersons().iterator();
    L26:
        if (r9.hasNext() == false) goto L38;
        PersonInfo r5 = (PersonInfo) r9.next();
        if (k.b(r5.getAvatarKey()) == true) goto L29;
        if (k.b(r5.getId()) == false) goto L26;
        String r6 = r5.getId();
        if (r6 == null) goto L26;
        r4.add(r6);
        goto L26
    L29:
        String r10 = r5.getAvatarKey();
        if (r10 == null) goto L26;
        Lazy<SimpleUserLoader> r11 = SimpleUserLoader.d;
        SimpleUserLoader.a.a().c(r10, new e(this));
        goto L26
    L38:
        if ((!r4.isEmpty()) == false) goto L40;
        Lazy<SimpleUserLoader> r12 = SimpleUserLoader.d;
        SimpleUserLoader.a.a().b(r4, new f(this));
    L40:
        TraceEvent.endSection("PersonListLynxUI.setContent");
        return;
    L13:
        if (r0.intValue() <= 0) goto L15;
        boolean r13 = true;
    L16:
        if (r13 == false) goto L18;
        r2 = r0;
    L18:
        if (r2 == null) goto L20;
        ((PersonListTextView) ((LynxUI) this).mView).setMaxLines(r2.intValue());
        goto L21
    L15:
        r13 = false;
    L5:
        th = move-exception;
        Log.e("CardPersonListLynxUI", "props from lynx transform failed", th);
        r8 = null;
        goto L7
    }

    public final void updateExtraData(Object r2) {
        super/*com.lynx.tasm.behavior.ui.LynxBaseUI*/.updateExtraData(r2);
        if (r2 != null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        ((PersonListTextView) ((LynxUI) this).mView).setText((CharSequence) r2);
        return;
    L9:
        return;
    L5:
        r0 = r2 instanceof CharSequence;
        goto L6
    }
}
