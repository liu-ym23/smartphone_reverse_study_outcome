package com.larus.business.markdown.impl.markwon;

import android.content.Context;
import com.larus.business.markdown.api.model.MarkdownNodeModifyType;
import com.larus.business.markdown.impl.common.MarkdownConfigManager;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import lw8.d;
import lw8.h;
import lw8.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Luvc/b;", "invoke", "()Luvc/b;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
public final class MarkwonContent$Companion$createNode$1 extends Lambda implements Function0<uvc.b> {
    final /* synthetic */ Function1<m, Unit> $callBack;
    final /* synthetic */ String $content;
    final /* synthetic */ Context $context;
    final /* synthetic */ d $customMarkDownInfo;
    final /* synthetic */ boolean $finished;
    final /* synthetic */ MarkdownConfigManager $markdownConfigManager;
    final /* synthetic */ h $markwonStructCache;
    final /* synthetic */ Function1<Set<? extends MarkdownNodeModifyType>, Unit> $nodeModifyCallback;

    /* JADX WARN: Multi-variable type inference failed */
    public MarkwonContent$Companion$createNode$1(h r1, boolean r2, Context r3, MarkdownConfigManager r4, d r5, String r6, Function1<? super Set<? extends MarkdownNodeModifyType>, Unit> r7, Function1<? super m, Unit> r8) {
        this.$markwonStructCache = r1;
        this.$finished = r2;
        this.$context = r3;
        this.$markdownConfigManager = r4;
        this.$customMarkDownInfo = r5;
        this.$content = r6;
        this.$nodeModifyCallback = r7;
        this.$callBack = r8;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final uvc.b m97invoke() {
        long r1 = System.currentTimeMillis();
        MarkwonStruct r3 = this.$markwonStructCache;
        if (r3 == null) goto L5;
    L14:
        long r5 = System.currentTimeMillis();
        Object r7 = MarkwonContent.n;
        String r8 = MarkwonContent.Companion.c(this.$content, this.$finished, this.$markdownConfigManager);
        if (this.$markdownConfigManager.a().b == true) goto L17;
    L19:
        long r9 = System.currentTimeMillis();
        uvc.b r4 = r3.a().a(r8, this.$finished);
        long r10 = System.currentTimeMillis();
        if (this.$finished == true) goto L22;
        Set r11 = this.$markdownConfigManager.a().c(r4);
    L23:
        Function1<Set<? extends MarkdownNodeModifyType>, Unit> r12 = this.$nodeModifyCallback;
        if (r12 == null) goto L26;
        r12.invoke(r11);
    L26:
        Function1<m, Unit> r13 = this.$callBack;
        if (r13 == null) goto L29;
        r13.invoke(new m(Long.valueOf(r5 - r1), Long.valueOf(r10 - r9), null, 4));
    L29:
        return r4;
    L22:
        r11 = null;
        goto L23
    L17:
        if (this.$finished == true) goto L19;
        r8 = MarkwonContent.Companion.b(r8);
        goto L19
    L5:
        if (this.$finished == false) goto L10;
        Context r6 = this.$context;
        MarkdownConfigManager r14 = this.$markdownConfigManager;
        d r15 = this.$customMarkDownInfo;
        if (r15 != null) goto L9;
        r15 = new d(0, null, null, false, null, 0, null, 0.0f, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 31);
    L9:
        r3 = e.a(r6, r14, null, r15, null);
        goto L14
    L10:
        Context r16 = this.$context;
        MarkdownConfigManager r17 = this.$markdownConfigManager;
        d r18 = this.$customMarkDownInfo;
        if (r18 != null) goto L13;
        r18 = new d(0, null, null, false, null, 0, null, 0.0f, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 31);
    L13:
        r3 = e.b(r16, r17, null, r18, null);
        goto L14
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m97invoke();
    }
}
