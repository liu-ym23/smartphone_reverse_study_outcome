package com.ss.android.ugc.effectmanager.common.listener;

import com.ss.android.ugc.effectmanager.common.EffectRequest;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface IEffectNetWorker {
    InputStream execute(EffectRequest r1) throws IOException;
}
