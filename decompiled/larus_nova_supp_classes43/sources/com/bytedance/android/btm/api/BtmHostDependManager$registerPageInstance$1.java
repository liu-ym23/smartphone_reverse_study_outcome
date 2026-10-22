package com.bytedance.android.btm.api;

import com.byted.cast.sink.api.IAPI;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
public final class BtmHostDependManager$registerPageInstance$1 extends Lambda implements Function0<String> {
    final /* synthetic */ boolean $auto;
    final /* synthetic */ String $btm;
    final /* synthetic */ Object $page;

    public BtmHostDependManager$registerPageInstance$1(Object r1, String r10, boolean r11) {
        this.$page = r1;
        this.$btm = r10;
        this.$auto = r11;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final String m574invoke() {
        return "page: " + this.$page.getClass().getName() + "\nbtm: " + this.$btm + "\nauto: " + this.$auto;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m574invoke();
    }
}
