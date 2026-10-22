package com.bytedance.android.btm.impl.page.model;

import com.byted.cast.sink.api.IAPI;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
public final class PageInfoStack$onFEJump$1 extends Lambda implements Function0<String> {
    final /* synthetic */ boolean $back;
    final /* synthetic */ String $newPageBtm;
    final /* synthetic */ String $pageClassName;
    final /* synthetic */ PageInfoStack this$0;

    public PageInfoStack$onFEJump$1(PageInfoStack r1, String r10, String r11, boolean r12) {
        this.this$0 = r1;
        this.$pageClassName = r10;
        this.$newPageBtm = r11;
        this.$back = r12;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final String m868invoke() {
        return "page : " + this.$pageClassName + "\nnewPageBtm: " + this.$newPageBtm + ", back: " + this.$back + ", stack: " + PageInfoStack.access$getStack$p(this.this$0).size();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m868invoke();
    }
}
