package com.ss.android.lark.chat.api.service.impl;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.MessageSource;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.basic.v1.TranslateMessageUrlPreviewsRequest;
import com.bytedance.lark.pb.basic.v1.TranslateUrlPreviewContext;
import com.bytedance.lark.pb.im.v1.GetTranslateLanguagesRequest;
import com.bytedance.lark.pb.im.v1.SetAutoTranslateGlobalSwitchRequest;
import com.bytedance.lark.pb.im.v1.SetTranslateLanguageRequest;
import com.bytedance.lark.pb.im.v1.TranslateMessageContext;
import com.bytedance.lark.pb.im.v1.TranslateMessagesV3Request;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.api.service.ITranslateService;
import com.ss.android.lark.chat.entity.translate.TranslateLanguageSetting;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.passportc.dwarf.UserScope;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class TranslateService implements ITranslateService {
    public final nyb.b a;
    public final t0 b;

    @Inject
    public TranslateService(t0 r2) {
        this.a = new nyb.b();
        this.b = r2;
    }

    @Override // com.ss.android.lark.chat.api.service.ITranslateService
    public final void getTranslateLanguages(IGetDataCallback r2) {
        s9(SyncDataStrategy.FORCE_SERVER, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.ss.android.lark.chat.api.service.impl.c2] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.ss.android.lark.chat.api.service.ITranslateService
    public final void L4(String r4, final IGetDataCallback<Boolean> r5) {
        SetTranslateLanguageRequest.Builder r6 = new SetTranslateLanguageRequest.Builder().language(r4);
        this.b.a(r6, new c2(), new AnonymousClass2(this, r5));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.ss.android.lark.chat.api.service.impl.b2] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.ss.android.lark.chat.api.service.ITranslateService
    public final void cb(boolean r3, IGetDataCallback<Boolean> r4) {
        SetAutoTranslateGlobalSwitchRequest.Builder r5 = new SetAutoTranslateGlobalSwitchRequest.Builder().is_open(Boolean.valueOf(r3));
        this.b.e(r5, new b2(), r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.ss.android.lark.chat.api.service.impl.f2] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.ss.android.lark.chat.api.service.ITranslateService
    public final void s9(SyncDataStrategy r4, final IGetDataCallback<TranslateLanguageSetting> r5) {
        GetTranslateLanguagesRequest.Builder r0 = new GetTranslateLanguagesRequest.Builder();
        r0.sync_data_strategy(r4);
        this.b.c(r0, new f2(), new AnonymousClass1(this, r5));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.chat.api.service.impl.e2] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.ss.android.lark.chat.api.service.ITranslateService
    public final void W4(boolean r2, Map<String, TranslateUrlPreviewContext> r3, final Map<String, Map<String, PreviewHangPoint>> r4, IGetDataCallback<Map<String, Map<String, PreviewHangPoint>>> r5) {
        HashMap r6 = (HashMap) r3;
        if (r6.isEmpty() == false) goto L5;
        return;
    L5:
        ArrayList r0 = new ArrayList(r6.values());
        TranslateMessageUrlPreviewsRequest.Builder r7 = new TranslateMessageUrlPreviewsRequest.Builder().is_auto_translate(Boolean.valueOf(r2)).translate_contexts(r0);
        this.b.d(r7, new e2(r4), r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [com.ss.android.lark.chat.api.service.impl.d2] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.ss.android.lark.chat.api.service.ITranslateService
    public final void jf(List<String> r8, ITranslateService.TranslateTriggerType r9, String r10, List<MessageSource> r11, String r12, Map<String, Integer> r13, final boolean r14, IGetDataCallback<fcb.a> r15) {
        if (CollectionUtils.isEmpty(r8) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r12) == true) goto L24;
        ArrayList r0 = new ArrayList();
        final boolean r1 = false;
        int r2 = 0;
    L9:
        if (r2 >= r8.size()) goto L16;
        String r3 = (String) ListProtector.get(r8, r2);
        int r4 = r13.get(r3).intValue();
        if (r2 >= r11.size()) goto L13;
        MessageSource r5 = (MessageSource) ListProtector.get(r11, r2);
    L14:
        r0.add(new TranslateMessageContext.Builder().message_id(r3).message_source(r5).manual_target_language(r10).chat_id(r12).message_content_version(Integer.valueOf(r4)).build());
        r2 = r2 + 1;
        goto L9
    L13:
        r5 = null;
        goto L14
    L16:
        if (r9 == ITranslateService.TranslateTriggerType.AUTO) goto L18;
        r1 = true;
    L18:
        TranslateMessagesV3Request.Builder r16 = new TranslateMessagesV3Request.Builder().is_translate_by_user(Boolean.valueOf(r1)).is_from_message_update(Boolean.valueOf(r14)).translate_contexts(r0);
        this.b.b(r16, new d2(this, r1, r14), r15);
        return;
    }
}
