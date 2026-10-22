package com.larus.voice_setting.voice.dialog.v2.api;

import com.bytedance.retrofit2.http.POST;
import com.larus.network.bean.BizResponse;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H§@¢\u0006\u0002\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/voice_setting/voice/dialog/v2/api/VoiceMaterialApi;", NameKeys.UnloadStrategy_No_Strategy, "userVoiceMaterial", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/voice_setting/voice/dialog/v2/api/VoiceMaterialResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface VoiceMaterialApi {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    static {
        a = a.a;
    }

    @POST("/alice/user_voice/material")
    Object userVoiceMaterial(Continuation<? super BizResponse<s2a.a>> r1);
}
