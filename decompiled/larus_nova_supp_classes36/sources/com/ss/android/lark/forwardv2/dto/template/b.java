package com.ss.android.lark.forwardv2.dto.template;

import android.content.Intent;
import android.os.Bundle;
import com.ss.android.lark.forwardv2.dto.ForwardTarget;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface b {

    public interface a {
        void a(String r1, String r2, boolean r3);

        void b(String r1, boolean r2);

        void onSuccess(int r1, Intent r2);
    }

    void a(List<ForwardTarget> r1, Bundle r2, a r3);
}
