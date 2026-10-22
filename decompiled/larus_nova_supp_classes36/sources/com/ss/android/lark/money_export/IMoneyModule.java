package com.ss.android.lark.money_export;

import android.app.Activity;
import android.content.Context;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface IMoneyModule {
    void createRedPacket(Context r1, String r2, boolean r3, int r4, String r5, String r6);

    void initIAP();

    void openH5(Context r1, String r2);

    void openLynxPage(Context r1, String r2, boolean r3, boolean r4);

    void openRedPacket(Activity r1, String r2, String r3, boolean r4, boolean r5, boolean r6, String r7);

    void openWallet(Context r1);
}
