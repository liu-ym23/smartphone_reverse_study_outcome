package com.ss.android.lark.keyboard.biz.mention;

import com.ss.android.lark.biz.im.api.ChatterNameDisplayRule;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.keyboard.edittext.FlowKeyboardFunctionEditText;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.RichTextExtraInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FetchAllDataAtStrategy implements com.ss.android.lark.keyboard.edittext2.edittors.at.c<g>, dob.d {
    public final Function0<String> a;
    public final Class<g> b;
    public com.ss.android.lark.keyboard.edittext2.base.b c;
    public final Map<String, List<com.ss.android.lark.keyboard.edittext2.edittors.at.b<hob.c>>> d;
    public final Function1<List<? extends com.ss.android.lark.keyboard.edittext2.edittors.at.b<hob.c>>, Unit> e;
    public final Function2<hob.c, List<? extends com.ss.android.lark.keyboard.edittext2.edittors.at.b<hob.c>>, Unit> f;
    public Map<String, ? extends ChatChatter> g;
    public Map<String, Boolean> h;
    public String i;
    public final b j;

    public static final class a {
    }

    public static final class b {
        public final /* synthetic */ FetchAllDataAtStrategy a;

        public b(FetchAllDataAtStrategy r1) {
            this.a = r1;
        }

        public final void a(hob.c r3, com.ss.android.lark.keyboard.edittext2.edittors.at.b r4) {
            g r5 = (g) r3;
            Intrinsics.checkNotNullParameter(r5, "data");
            Intrinsics.checkNotNullParameter(r4, "result");
            String r6 = r5.a;
            List r0 = (List) ((LinkedHashMap) this.a.d).get(r6);
            if (r0 == null) goto L6;
            r0.add(r4);
            return;
        L6:
            if (this.a.d.size() < 100) goto L8;
            Log.w("FetchAllDataAtStrategy", "not load chatter, exceeded the limit, chatterId = " + r6);
            return;
        L8:
            ArrayList r1 = new ArrayList();
            r1.add(r4);
            this.a.d.put(r6, r1);
        }
    }

    static {
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.a
    public final void d() {
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.a
    public final com.ss.android.lark.keyboard.edittext2.base.b getTarget() {
        com.ss.android.lark.keyboard.edittext2.base.b r0 = this.c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("target");
        return null;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.at.c
    public Class<g> getType() {
        return this.b;
    }

    public FetchAllDataAtStrategy(Function0<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "chatIdProvider");
        this.a = r2;
        this.b = g.class;
        this.d = new LinkedHashMap();
        this.e = FetchAllDataAtStrategy$notifyFailedAction$1.INSTANCE;
        this.f = FetchAllDataAtStrategy$notifySuccessAction$1.INSTANCE;
        this.i = "";
        this.j = new b(this);
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.a
    public final void A(com.ss.android.lark.keyboard.edittext2.base.b r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.a
    public final void G(com.ss.android.lark.keyboard.edittext2.base.a r2) {
        Intrinsics.checkNotNullParameter(r2, "origin");
        Intrinsics.checkNotNullParameter(r2, "origin");
    }

    @Override // dob.d
    public final void a(RichText r7) {
        com.ss.android.lark.keyboard.edittext2.base.b r8 = getTarget();
        if ((r8 instanceof FlowKeyboardFunctionEditText) == false) goto L5;
        FlowKeyboardFunctionEditText r9 = (FlowKeyboardFunctionEditText) r8;
    L6:
        if (r9 == null) goto L9;
        final String r10 = r9.getCurChatId();
        if (r10 == null) goto L9;
    L11:
        if (r10.length() != 0) goto L13;
        boolean r0 = true;
    L14:
        if (r0 == false) goto L17;
        Log.e("FetchAllDataAtStrategy", "loaded return, chat id is empty");
        return;
    L17:
        final List r1 = CollectionsKt.toList(((LinkedHashMap) this.d).keySet());
        if (r1.size() != 0) goto L20;
        return;
    L20:
        AtomicInteger r2 = new AtomicInteger(2);
        com.larksuite.rucket.job.compat.f.a(new FetchAllDataAtStrategy$onRenderFinished$1(r10, r1)).then(Dispatchers.getMain(), new FetchAllDataAtStrategy$onRenderFinished$2(this, r10, r2, null)).error(Dispatchers.getMain(), new FetchAllDataAtStrategy$onRenderFinished$3(r10, this, r2, null));
        com.larksuite.rucket.job.compat.f.a(new FetchAllDataAtStrategy$onRenderFinished$4(r1, r10)).then(Dispatchers.getMain(), new FetchAllDataAtStrategy$onRenderFinished$5(this, r10, r2, null)).error(Dispatchers.getMain(), new FetchAllDataAtStrategy$onRenderFinished$6(r10, this, r2, null));
        return;
    L13:
        r0 = false;
    L9:
        r10 = "";
        goto L11
    L5:
        r9 = null;
        goto L6
    }

    @Override // dob.d
    public final void b(RichText r2) {
        ((LinkedHashMap) this.d).clear();
        this.g = null;
        this.h = null;
        if (r2 == null) goto L8;
        RichTextExtraInfo r3 = r2.getExtraInfo();
        if (r3 == null) goto L8;
        String r4 = r3.getCurChatId();
        if (r4 == null) goto L8;
    L9:
        this.i = r4;
        return;
    L8:
        r4 = "";
        goto L9
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.at.c
    public final com.ss.android.lark.keyboard.edittext2.edittors.at.a c(com.ss.android.lark.keyboard.edittext2.edittors.a r3, hob.c r4) {
        g r5 = (g) r4;
        Intrinsics.checkNotNullParameter(r3, "editor");
        Intrinsics.checkNotNullParameter(r5, "data");
        return new h(this.j, r3, r5);
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.at.c
    public final fob.c.a<g> k(com.ss.android.lark.keyboard.edittext2.edittors.a r6, RichTextElement.AtProperty r7) {
        Intrinsics.checkNotNullParameter(r6, "editor");
        Intrinsics.checkNotNullParameter(r7, "property");
        String r8 = (String) this.a.invoke();
        if (r8.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L28;
        if (Intrinsics.areEqual(r8, this.i) == true) goto L10;
    L20:
        String r9 = r7.getAtContent();
        if (r9 == null) goto L24;
        String r10 = r9.substring(1);
        if (r10 == null) goto L24;
    L26:
        return new fob.c.a(true, new g(r7.getUserId(), r10, r7.isAnonymous(), r7.isOutChatUser()));
    L24:
        r10 = "";
        goto L26
    L10:
        if (r8.length() <= 0) goto L12;
        boolean r11 = true;
    L13:
        if (r11 == false) goto L20;
        if (this.i.length() <= 0) goto L17;
        boolean r12 = true;
    L18:
        if (r12 == false) goto L20;
    L17:
        r12 = false;
        goto L18
    L12:
        r11 = false;
    L28:
        return new fob.c.a(false, null);
    L5:
        r0 = false;
        goto L6
    }

    public static final void e(FetchAllDataAtStrategy r12, String r13, AtomicInteger r14) {
        r12.getClass();
        if (r14.decrementAndGet() > 0) goto L69;
        Map<String, ? extends ChatChatter> r15 = r12.g;
        boolean r0 = false;
        if (r15 != null) goto L8;
    L11:
        boolean r16 = true;
    L13:
        if (r16 == true) goto L40;
        Map<String, Boolean> r17 = r12.h;
        if (r17 != null) goto L17;
    L20:
        boolean r18 = true;
    L21:
        if (r18 == true) goto L40;
        ChatterNameDisplayRule r19 = ChatterNameDisplayRule.ALIAS_NICKNAME_NAME;
        Iterator r1 = ((LinkedHashMap) r12.d).entrySet().iterator();
    L25:
        if (r1.hasNext() == false) goto L39;
        Map.Entry r3 = (Map.Entry) r1.next();
        String r4 = (String) r3.getKey();
        List r5 = (List) r3.getValue();
        Map<String, ? extends ChatChatter> r6 = r12.g;
        Boolean r7 = null;
        if (r6 == null) goto L29;
        ChatChatter r8 = r6.get(r4);
    L31:
        if (r8 == null) goto L32;
        Map<String, Boolean> r9 = r12.h;
        if (r9 == null) goto L36;
        r7 = r9.get(r4);
    L36:
        if (r7 == null) goto L37;
        String r10 = com.ss.android.lark.chat.utils.m.b(r8, r19, true);
        String r11 = r8.getLocalizedName();
        Intrinsics.checkNotNull(r10);
        hob.c r110 = new hob.c(r4, r10, r11, !r7.booleanValue(), r8.isAnonymous());
        String r20 = f.a;
        f.a(r110, r4);
        r12.f.invoke(r110, r5);
        goto L25
    L37:
        r12.e.invoke(r5);
        Log.e("FetchAllDataAtStrategy", "parse failed, isInChat is null, chatId = " + r13 + ", chatterId = " + r4);
        goto L25
    L32:
        r12.e.invoke(r5);
        Log.e("FetchAllDataAtStrategy", "parse failed, chatter is null, chatId = " + r13 + ", chatterId = " + r4);
        goto L25
    L29:
        r8 = null;
        goto L31
    L39:
        ((LinkedHashMap) r12.d).clear();
        return;
    L17:
        if (r17.isEmpty() == true) goto L20;
        r18 = false;
    L40:
        StringBuilder r111 = new StringBuilder("onRequestSuccess, chat id = ");
        r111.append(r13);
        r111.append(", chatters is empty = ");
        Map<String, ? extends ChatChatter> r112 = r12.g;
        if (r112 != null) goto L43;
    L46:
        boolean r113 = true;
    L47:
        r111.append(r113);
        r111.append(", inChats is null ");
        Map<String, Boolean> r114 = r12.h;
        if (r114 != null) goto L50;
    L51:
        r0 = true;
    L52:
        r111.append(r0);
        Log.i("FetchAllDataAtStrategy", r111.toString());
        Iterator r115 = ((LinkedHashMap) r12.d).entrySet().iterator();
    L54:
        if (r115.hasNext() == false) goto L56;
        r12.e.invoke(((Map.Entry) r115.next()).getValue());
        goto L54
    L56:
        ((LinkedHashMap) r12.d).clear();
        return;
    L50:
        if (r114.isEmpty() == false) goto L52;
    L43:
        if (r112.isEmpty() == true) goto L46;
        r113 = false;
        goto L47
    L8:
        if (r15.isEmpty() == true) goto L11;
        r16 = false;
        goto L13
    }
}
