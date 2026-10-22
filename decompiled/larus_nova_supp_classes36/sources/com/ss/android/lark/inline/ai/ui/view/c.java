package com.ss.android.lark.inline.ai.ui.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.biz.im.api.IIMApi;
import com.ss.android.lark.inline.ai.api.MentionType;
import com.ss.android.lark.inline.ai.api.ScenarioType;
import com.ss.android.lark.inline.ai.api.ui.Input;
import com.ss.android.lark.inline.ai.api.ui.ParamDetail;
import com.ss.android.lark.inline.ai.api.ui.ParamResultDetail;
import com.ss.android.lark.inline.ai.api.ui.TextContentList;
import com.ss.android.lark.inline.ai.api.ui.TextResultContentList;
import com.ss.android.lark.inline.ai.ui.InlineAIEditText;
import com.ss.android.lark.inline.ai.ui.InlineAIPanelController;
import com.ss.android.lark.inline.ai.ui.selector.SelectorActivity;
import com.ss.android.lark.inline.ai.utils.StringUtils;
import com.ss.android.lark.keyboard.edittext2.span.f;
import com.ss.android.lark.keyboard.edittext2.span.l;
import com.ss.android.lark.keyboard.edittext2.span.m;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.member_manage.export.mention.IMMentionTabConfig;
import com.ss.android.lark.member_manage.export.mention.IMMentionViewType;
import com.ss.android.lark.myai.chat.quickactions.QuickActionNameSpan;
import com.ss.android.lark.myai.chat.quickactions.QuickActionParamPlaceholderSpan;
import com.ss.android.lark.myai.chat.quickactions.QuickActionParamSpan;
import com.ss.android.lark.myai.chat.quickactions.QuickActionSpan;
import com.ss.android.lark.myai.chat.quickactions.QuickActionsTemplateFormatter;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.ContextsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONArray;
import wlb.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements com.ss.android.lark.inline.ai.ui.view.b {
    public static final /* synthetic */ int k = 0;
    public final h a;
    public final b b;
    public boolean c;
    public boolean d;
    public boolean e;
    public TextContentList f;
    public sbb.a g;
    public String h;
    public boolean i;
    public com.ss.android.lark.inline.ai.ui.at.a j;

    public static final class a {
    }

    public interface b {
        Input getInput();
    }

    /* JADX INFO: renamed from: com.ss.android.lark.inline.ai.ui.view.c$c, reason: collision with other inner class name */
    public static final class RunnableC0112c implements Runnable {
        public final /* synthetic */ EditText a;

        public RunnableC0112c(EditText r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            EditText r0 = this.a;     // Catch: Throwable -> L4
            r0.setSelection(0, r0.length());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final boolean b() {
        wlb.a r0 = this.a.e;
        if (r0 == null) goto L5;
        MentionType r1 = r0.a;
    L7:
        if (r1 == MentionType.DEFAULT) goto L9;
        return true;
    L9:
        return false;
    L5:
        r1 = null;
        goto L7
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r6) {
        boolean r1 = false;
        if ((r6 instanceof Spanned) == false) goto L8;
        Object[] r0 = r6.getSpans(0, r6.length(), l.class);
        int r2 = r0.length;
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L8;
        ((l) r0[r3]).b(r6);
        r3 = r3 + 1;
    L8:
        if (r6 != null) goto L10;
    L11:
        r1 = true;
    L12:
        if (r1 == false) goto L15;
        this.f = null;
    L15:
        if (TextUtils.isEmpty(r6) == false) goto L17;
    L18:
        this.i = true;
        Log.i("InlineEditTextFunctionImpl", "afterTextChanged :  placeholderTextChanged=true");
        return;
    L17:
        if (TextUtils.equals(this.h, String.valueOf(r6)) == true) goto L18;
        return;
    L10:
        if (r6.length() != 0) goto L12;
        goto L11
    }

    public final void e(SpannableStringBuilder r17) {
        if (this.g != null) goto L5;
        this.g = new sbb.a(new sbb.b(SettingManager.getInstance().getSettingConfig("domain_config", true)));
    L5:
        f[] r2 = (f[]) r17.getSpans(0, r17.length(), f.class);
        int r4 = r2.length;
        int r6 = 0;
    L6:
        if (r6 >= r4) goto L39;
        f r7 = r2[r6];
        int r8 = r17.getSpanStart(r7);
        int r9 = r17.getSpanEnd(r7);
        String r13 = "";
        if ((r7 instanceof m) == false) goto L28;
        sbb.a r10 = this.g;
        if (r10 == null) goto L13;
        String r11 = r10.b(((m) r7).c);
        if (r11 == null) goto L13;
    L14:
        int r12 = sbb.e.g(r11);
        sbb.a r14 = this.g;
        if (r14 == null) goto L18;
        String r15 = r14.a(((m) r7).c);
        if (r15 == null) goto L18;
    L19:
        Log.i("InlineEditTextFunctionImpl", "urlSpanParser: type= " + r12 + " ; token Empty: " + TextUtils.isEmpty(r15));
        if (r8 < 0) goto L23;
        if (r8 > r9) goto L23;
        boolean r3 = true;
    L24:
        if (r3 == false) goto L26;
        m r16 = (m) r7;
        r13 = r16.c;
        String r5 = r16.b;
    L38:
        r17.replace(r8, r9, "<at type=\"" + r12 + "\" href=\"" + r13 + "\" token=\"" + r15 + "\">" + r5 + "</at>");
        r6 = r6 + 1;
        goto L6
    L26:
        Log.i("InlineEditTextFunctionImpl", "urlSpanParser UrlPreviewSpan spanStart: " + r8 + ", " + r9);
        r5 = "";
    L23:
        r3 = false;
    L18:
        r15 = "";
    L13:
        r11 = "";
        goto L14
    L28:
        if ((r7 instanceof com.ss.android.lark.keyboard.edittext2.span.a) == false) goto L36;
        if (r8 < 0) goto L32;
        if (r8 > r9) goto L32;
        boolean r18 = true;
    L33:
        if (r18 == false) goto L35;
        r5 = r17.subSequence(r8, r9).toString();
        r15 = ((com.ss.android.lark.keyboard.edittext2.span.a) r7).b;
    L37:
        r12 = 0;
        goto L38
    L35:
        Log.i("InlineEditTextFunctionImpl", "urlSpanParser  AtTagSpanV2 spanStart: " + r8 + ", " + r9);
    L32:
        r18 = false;
    L36:
        r5 = "";
        r15 = r5;
        goto L37
    }

    @Override // com.ss.android.lark.inline.ai.ui.view.b
    public final Object t(EditText r14) {
        Intrinsics.checkNotNullParameter(r14, "editText");
        if ((r14.getText() instanceof SpannableStringBuilder) == false) goto L40;
        SpannableStringBuilder r0 = new SpannableStringBuilder(r14.getText());
        TextContentList r15 = this.f;
        if (r15 == null) goto L35;
        Map r3 = com.ss.android.lark.myai.chat.quickactions.b.a(r0);
        TextResultContentList r4 = new TextResultContentList(null, 1, null);
        r4.setDisplayName(r15.getDisplayName());
        r4.setDisplayContent(r0.toString());
        r4.setParamDetails(new ArrayList());
        Iterator r1 = ((LinkedHashMap) r3).entrySet().iterator();
    L8:
        if (r1.hasNext() == false) goto L32;
        Map.Entry r5 = (Map.Entry) r1.next();
        ArrayList<ParamDetail> r6 = r15.getParamDetails();
        if (r6 == null) goto L24;
        Iterator<ParamDetail> r7 = r6.iterator();
    L13:
        if (r7.hasNext() == false) goto L22;
        ParamDetail r8 = r7.next();
        if (Intrinsics.areEqual(r8.getName(), r5.getKey()) == false) goto L13;
        String r9 = r8.getKey();
        if (r9 != null) goto L19;
        r9 = "";
    L19:
        String r10 = r8.getPlaceHolder();
        if (r10 != null) goto L23;
        r10 = "";
    L23:
        String r11 = r9;
        String r12 = r10;
    L25:
        String r13 = r5.getValue().toString();
        if ((r5.getValue() instanceof SpannableStringBuilder) == false) goto L28;
        Object r16 = r5.getValue();
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type android.text.SpannableStringBuilder");
        SpannableStringBuilder r17 = (SpannableStringBuilder) r16;
        e(r17);
        String r18 = r17.toString();
    L29:
        String r19 = r18;
        Intrinsics.checkNotNull(r19);
        ArrayList<ParamResultDetail> r20 = r4.getParamDetails();
        if (r20 == null) goto L8;
        r20.add(new ParamResultDetail(r11, r5.getKey().toString(), r12, r19, r13));
        goto L8
    L28:
        r18 = r5.getValue().toString();
        goto L29
    L22:
        r9 = "";
        r10 = r9;
        goto L23
    L24:
        r11 = "";
        r12 = r11;
        goto L25
    L32:
        Log.d("InlineEditTextFunctionImpl", "getEditTextContent result list = " + r4);
        return r4;
    L35:
        if (b() == true) goto L38;
        String r110 = r0.toString();
        Log.d("InlineEditTextFunctionImpl", "getEditTextContent result=" + r110);
        return r110;
    L38:
        e(r0);
        Log.d("InlineEditTextFunctionImpl", "getEditTextContent at result=" + r0);
        return r0.toString();
    L40:
        return "";
    }

    public c(h r2, InlineAIPanelController.a r3) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "delegate");
        this.a = r2;
        this.b = r3;
        this.h = "";
    }

    @Override // com.ss.android.lark.inline.ai.ui.view.b
    public final void B(EditText r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "editText");
        Editable r0 = r3.getText();
        String r1 = "";
        if (r4 == false) goto L5;
        Input r5 = this.b.getInput();
        if (r5 != null) goto L14;
        return;
    L14:
        if (TextUtils.isEmpty(r0) == true) goto L16;
        return;
    L16:
        if (r5.getPlacehoderSelected() == true) goto L19;
        return;
    L19:
        if (r5.getTextContentList() == null) goto L23;
        TextContentList r6 = r5.getTextContentList();
        if (r6 == null) goto L38;
        d(r3, r6);
        this.h = r3.getText().toString();
    L38:
        if (TextUtils.isEmpty(this.h) == true) goto L44;
        r3.postDelayed(new RunnableC0112c(r3), 200);
        return;
    L44:
        return;
    L23:
        String r7 = r5.getPlaceholder();
        if (r7 == null) goto L27;
        r1 = r7;
    L27:
        com.ss.android.lark.inline.ai.ui.at.a r8 = this.j;
        if (r8 == null) goto L30;
        boolean r9 = r8.a(r1);
    L31:
        if (r9 == false) goto L35;
        com.ss.android.lark.inline.ai.ui.at.a r10 = this.j;
        if (r10 == null) goto L36;
        r10.b(r1, r3);
    L36:
        this.h = r3.getText().toString();
        goto L38
    L35:
        r3.setText(r3.getHint().toString());
        goto L36
    L30:
        r9 = false;
        goto L31
    L5:
        if (TextUtils.equals(this.h, r0) == true) goto L7;
        return;
    L7:
        if (this.i == true) goto L42;
        r3.setText("");
        r3.setHint(r0);
        return;
    }

    public final void d(EditText r22, TextContentList r23) {
        Intrinsics.checkNotNullParameter(r22, "editText");
        Intrinsics.checkNotNullParameter(r23, "content");
        SpannableStringBuilder r4 = new SpannableStringBuilder();
        QuickActionsTemplateFormatter r5 = new QuickActionsTemplateFormatter();
        ArrayList<ParamDetail> r6 = r23.getParamDetails();
        String r10 = "";
        if (r6 == null) goto L39;
        Iterator<T> r7 = r6.iterator();
    L6:
        if (r7.hasNext() == false) goto L39;
        ParamDetail r11 = (ParamDetail) r7.next();
        String r12 = r11.getName();
        if (r12 != null) goto L10;
        String r16 = "";
    L11:
        String r13 = r11.getPlaceHolder();
        if (r13 != null) goto L14;
        String r18 = "";
    L15:
        String r14 = r11.getUserInput();
        if (r14 != null) goto L21;
        String r15 = r11.getContent();
        if (r15 != null) goto L20;
        String r19 = "";
    L22:
        com.ss.android.lark.myai.chat.keyboardtop.a.b r17 = new com.ss.android.lark.myai.chat.keyboardtop.a.b(r16, "", r16, "", r18, r19, "");
        Intrinsics.checkNotNullParameter(r17, "param");
        QuickActionParamSpan r110 = new QuickActionParamSpan(r17.a, r17.d, r17.e, r17.f);
        SpannableStringBuilder r9 = new SpannableStringBuilder((String) r5.a.getValue());
        if (r17.g.length() <= 0) goto L25;
        boolean r111 = true;
    L26:
        if (r111 == false) goto L29;
        CharSequence r112 = r17.g;
    L34:
        boolean r113 = false;
    L36:
        if (r113 == false) goto L38;
        r9.setSpan(new QuickActionParamPlaceholderSpan(), r5.e.getFirst(), r5.e.getLast(), 33);
    L38:
        r9.setSpan(r110, r5.d.getFirst(), r5.d.getLast(), 33);
        StringBuilder r8 = new StringBuilder(r17.d);
        r8.insert(0, " ");
        int r114 = (r8.length() - r5.c.getLast()) + r5.c.getFirst();
        r9.replace(r5.c.getFirst(), r5.c.getLast(), r8);
        r9.replace(r5.e.getFirst() + r114, r5.e.getLast() + r114, r112);
        r4.append(r9);
        goto L6
    L29:
        if (r17.h.length() <= 0) goto L31;
        boolean r115 = true;
    L32:
        if (r115 == false) goto L35;
        r112 = r17.h;
        goto L34
    L35:
        r112 = r17.f;
        r113 = true;
        goto L36
    L31:
        r115 = false;
        goto L32
    L25:
        r111 = false;
        goto L26
    L20:
        r19 = r15;
        goto L22
    L21:
        r19 = r14;
        goto L22
    L14:
        r18 = r13;
        goto L15
    L10:
        r16 = r12;
    L39:
        String r3 = r23.getDisplayName();
        if (r3 == null) goto L43;
        r10 = r3;
    L43:
        Intrinsics.checkNotNullParameter(r10, "quickActionName");
        Intrinsics.checkNotNullParameter(r4, "content");
        SpannableStringBuilder r2 = new SpannableStringBuilder((String) r5.b.getValue());
        r2.setSpan(new QuickActionNameSpan(r10), r5.g.getFirst(), r5.g.getLast(), 33);
        r2.replace(r5.f.getFirst(), r5.f.getLast(), r10);
        int r20 = (r10.length() - r5.f.getLast()) + r5.f.getFirst();
        r2.replace(r5.h.getFirst() + r20, r5.h.getLast() + r20, r4);
        r2.setSpan(new QuickActionSpan(), 0, r2.length(), 18);
        com.ss.android.lark.inline.ai.ui.at.a r21 = this.j;
        if (r21 != null) goto L46;
    L48:
        boolean r24 = false;
    L49:
        if (r24 == false) goto L53;
        com.ss.android.lark.inline.ai.ui.at.a r25 = this.j;
        if (r25 == null) goto L58;
        r25.b(r2.toString(), r22);
        return;
    L58:
        return;
    L53:
        r22.setText(r2);
        return;
    L46:
        if (r21.a(r2.toString()) != true) goto L48;
        r24 = true;
        goto L49
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c(ScenarioType r18, InlineAIEditText r19, List r20) {
        Intrinsics.checkNotNullParameter(r18, "scenario");
        Intrinsics.checkNotNullParameter(r19, "editText");
        Intrinsics.checkNotNullParameter(r20, "searchBaseInfos");
        if (this.g != null) goto L5;
        this.g = new sbb.a(new sbb.b(SettingManager.getInstance().getSettingConfig("domain_config", true)));
    L5:
        JSONArray r6 = new JSONArray();
        Ref.BooleanRef r3 = new Ref.BooleanRef();
        Ref.BooleanRef r4 = new Ref.BooleanRef();
        ArrayList r2 = new ArrayList();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.a.getActivity()), null, null, new InlineEditTextFunctionImpl$insertSearchResult$1(r20, r2, r3, r4, r18, r6, this, r19, null), 3, null);
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r5, int r6, int r7, int r8) {
        if ((r5 instanceof Spanned) == false) goto L7;
        Spanned r0 = (Spanned) r5;
        int r3 = 0;
        Object[] r1 = r0.getSpans(0, r0.length(), l.class);
        int r2 = r1.length;
    L5:
        if (r3 >= r2) goto L9;
        ((l) r1[r3]).a(r5, r6, r7, r8);
        r3 = r3 + 1;
        goto L5
    L9:
        return;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r6, int r7, int r8, int r9) {
        if ((r6 instanceof Spanned) == false) goto L8;
        Spanned r0 = (Spanned) r6;
        Object[] r1 = r0.getSpans(0, r0.length(), l.class);
        int r2 = r1.length;
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L8;
        ((l) r1[r3]).c(r6);
        r3 = r3 + 1;
    L8:
        if (b() == true) goto L11;
        return;
    L11:
        if (r8 < 0) goto L14;
        if (r9 <= 0) goto L14;
        boolean r4 = true;
    L15:
        this.c = r4;
        if (r8 <= 0) goto L19;
        if (r9 != 0) goto L19;
        boolean r10 = true;
    L20:
        this.d = r10;
        Log.d("InlineEditTextFunctionImpl", "onTextChanged: addText=" + this.c + "，delText=" + this.d + "，start=" + r7);
        if (this.c == false) goto L69;
        if (r9 != 1) goto L70;
        if (r6 != null) goto L25;
    L27:
        boolean r11 = false;
    L28:
        if (r11 == false) goto L71;
        if (r7 <= 0) goto L39;
        char r12 = r6.charAt(r7 - 1);
        StringUtils r13 = StringUtils.a;
        Pattern r14 = PatternProtector.compile("[0-9]*");
        Pattern r15 = PatternProtector.compile("[A-z]*");
        String r16 = String.valueOf(r12);
        if (r14.matcher(r16).matches() == false) goto L33;
    L36:
        boolean r17 = true;
    L37:
        if (r17 == false) goto L39;
        boolean r18 = true;
    L40:
        if (r18 == true) goto L42;
    L44:
        h r19 = this.a;
        wlb.a r20 = r19.e;
        if (r20 == null) goto L47;
        MentionType r21 = r20.a;
    L49:
        if (r21 != MentionType.ALL) goto L53;
        Activity r22 = ContextsKt.findActivity(r19.getActivity());
        if (r22 == null) goto L66;
        Bundle r23 = new Bundle();
        r23.putFloat("mention_panel_height_percent", 0.9f);
        r23.putParcelableArrayList("mention_panel_tab_config", CollectionsKt.arrayListOf(new IMMentionTabConfig[]{new IMMentionTabConfig(IMMentionViewType.INLINE_AI_ALL, this.a.getActivity().getString(2131888934)), new IMMentionTabConfig(IMMentionViewType.INLINE_AI_DOC, this.a.getActivity().getString(2131888935)), new IMMentionTabConfig(IMMentionViewType.INLINE_AI_CONTRACT, this.a.getActivity().getString(2131888936))}));
        ((IIMApi) ApiUtils.getApi(IIMApi.class)).showIMMentionActivity(r22, this.a.b, r23, 39315);
    L66:
        this.e = false;
        return;
    L53:
        Activity r24 = ContextsKt.findActivity(r19.getActivity());
        if (r24 == null) goto L66;
        Intent r25 = new Intent(r24, SelectorActivity.class);
        Bundle r26 = new Bundle();
        wlb.a r27 = this.a.e;
        if (r27 == null) goto L62;
        MentionType r28 = r27.a;
        if (r28 == null) goto L62;
        String r29 = r28.getValue();
        if (r29 == null) goto L62;
        r26.putString("mention_type", r29);
    L62:
        r25.putExtras(r26);
        Fragment r30 = this.a.b;
        if (r30 == null) goto L65;
        r30.startActivityForResult(r25, 39314);
        goto L66
    L65:
        r24.startActivityForResult(r25, 39314);
        goto L66
    L47:
        r21 = null;
        goto L49
    L42:
        if (this.e == true) goto L44;
        Log.i("InlineEditTextFunctionImpl", "onTextChanged: isNumericOrLetters not trigger at");
        return;
    L33:
        if (r15.matcher(r16).matches() == true) goto L36;
        r17 = false;
    L39:
        r18 = false;
        goto L40
    L71:
        return;
    L25:
        if (r6.charAt(r7) != '@') goto L27;
        r11 = true;
        goto L28
    L70:
        return;
    L69:
        return;
    L19:
        r10 = false;
    L14:
        r4 = false;
        goto L15
    }

    public static final void a(c r4, EditText r5, String r6, String r7, String r8) {
        r4.getClass();
        m r9 = new m(new m.a(r5.getContext(), r6, r7, r8));
        SpannableStringBuilder r10 = r9.e;
        if (r10 == null) goto L18;
        Editable r11 = r5.getEditableText();
        int r12 = r5.getSelectionStart();
        boolean r0 = true;
        if (r12 < 1) goto L9;
        int r2 = r12 - 1;
        if (r11.toString().charAt(r2) != '@') goto L9;
        r12 = r2;
    L9:
        int r1 = r5.getSelectionEnd();
        if (r12 < 0) goto L13;
        if (r12 > r1) goto L13;
    L14:
        if (r0 == false) goto L16;
        r11.replace(r12, r1, r10);
        int r13 = URLRecognition.a;
        Intrinsics.checkNotNullParameter(r5, "editText");
        Intrinsics.checkNotNullParameter(r9, "span");
        ncc.d r14 = new e(r5);
        Intrinsics.checkNotNullParameter(r14, "callback");
        r9.f.setCallback(r14);
        r9.f.invalidateSelf();
        return;
    L16:
        Log.e("InlineEditTextFunctionImpl", "url parser err: start = " + r12 + ", end=" + r1);
        return;
    L13:
        r0 = false;
        goto L14
    }
}
