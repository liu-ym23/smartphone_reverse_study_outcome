package com.obric.aikernel.isolate.api;

import android.content.pm.PackageManager;
import com.bytedance.news.common.service.manager.IService;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.f1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface IDebugPssCollect extends IService {
    boolean canBind(PackageManager r10, String r11);

    f1<Unit> getDebugNextPack();

    ArrayList<JSONObject> getDebugPackMemoryResult();

    boolean isDebugOpen();

    void nextPack();

    Object waitNextDebugPack(Continuation<? super Unit> r10);
}
