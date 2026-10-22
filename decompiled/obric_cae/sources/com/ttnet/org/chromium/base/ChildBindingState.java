package com.ttnet.org.chromium.base;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface ChildBindingState {
    public static final int MAX_VALUE = 3;
    public static final int MODERATE = 2;
    public static final int STRONG = 3;
    public static final int UNBOUND = 0;
    public static final int WAIVED = 1;
}
