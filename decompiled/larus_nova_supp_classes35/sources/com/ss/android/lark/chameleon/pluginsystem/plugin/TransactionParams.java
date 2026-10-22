package com.ss.android.lark.chameleon.pluginsystem.plugin;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class TransactionParams {
    public boolean addToBackStack;
    public int enterAnimation;
    public int exitAnimation;
    public int popEnterAnimation;
    public int popExitAnimation;

    public TransactionParams() {
    }

    public TransactionParams addToBackStack() {
        this.addToBackStack = true;
        return this;
    }

    public TransactionParams setEnterAnimation(int r1) {
        this.enterAnimation = r1;
        return this;
    }

    public TransactionParams setExitAnimation(int r1) {
        this.exitAnimation = r1;
        return this;
    }

    public TransactionParams setPopEnterAnimation(int r1) {
        this.popEnterAnimation = r1;
        return this;
    }

    public TransactionParams setPopExitAnimation(int r1) {
        this.popExitAnimation = r1;
        return this;
    }

    public static TransactionParams ofAnimation(int r1, int r2) {
        return ofAnimation(r1, r2, 0, 0);
    }

    public static TransactionParams ofAnimation(int r1, int r2, int r3, int r4) {
        TransactionParams r0 = new TransactionParams();
        r0.enterAnimation = r1;
        r0.exitAnimation = r2;
        r0.popEnterAnimation = r3;
        r0.popExitAnimation = r4;
        return r0;
    }
}
