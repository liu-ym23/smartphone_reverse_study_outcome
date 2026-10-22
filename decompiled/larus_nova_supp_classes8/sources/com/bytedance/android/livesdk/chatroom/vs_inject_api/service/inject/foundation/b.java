package com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.Map;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface b {
    void a(String r1, Map<String, String> r2, Context r3);

    void c(Context r1, Uri r2, Bundle r3);

    void d(FragmentActivity r1, Fragment r2, boolean r3);

    void f(Context r1, IRoom r2, Bundle r3);

    void g(Activity r1, Function1 r2);

    xu1.a getColorWeakModelEffectInfo();

    boolean h();

    void handleSchema(Context r1, Uri r2);

    void handleSchema(Context r1, String r2);

    boolean isNeedProtectUnderage();

    boolean isNetworkStateChanged();

    void startLive(Context r1, long r2, Bundle r4);
}
