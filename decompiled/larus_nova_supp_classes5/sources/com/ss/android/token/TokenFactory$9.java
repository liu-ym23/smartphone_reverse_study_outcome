package com.ss.android.token;

import java.util.HashSet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class TokenFactory$9 extends HashSet<String> {
    final /* synthetic */ TokenFactory this$0;

    public TokenFactory$9(TokenFactory r1) {
        this.this$0 = r1;
        add("/passport/mobile/check_qrconnect/");
        add("/passport/user/logout/");
        add("/passport/account/switch/");
        add("/passport/vcd/switch_account/");
        add("/passport/account/switch_relation_user/");
    }
}
