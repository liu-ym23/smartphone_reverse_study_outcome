package com.larus.bmhome.view.screenmenu;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface e0 {
    void a(k0 r1, com.larus.bmhome.chat.manager.k r2);

    void b(k0 r1, Function0<Unit> r2);

    void c(k0 r1, Function0<Unit> r2);

    void setOnCopyWorkingDirectoryPathListener(Function0<Unit> r1);

    void setOnHideListener(Function0<Unit> r1);

    void setOnPinListener(Function0<Unit> r1);

    void setOnRefreshListener(Function0<Unit> r1);

    void setOnRemoveFromProjectListener(Function0<Unit> r1);

    void setOnShareMessageListener(Function0<Unit> r1);

    void setOnUnpinListener(Function0<Unit> r1);
}
