package com.bytedance.geckox;

import android.text.TextUtils;
import com.bytedance.forest.chain.fetchers.GeckoFetcher;
import com.bytedance.geckox.model.CheckRequestBodyModel;
import com.bytedance.geckox.model.CheckRequestParamModel;
import com.bytedance.iesgurd.core.ReqType;
import com.bytedance.iesgurd.model.DeploymentsData;
import com.bytedance.iesgurd.model.RequestBodyUpdate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class m {
    public static void a(j r12, Map r13, OptionCheckUpdateParams r14) {
        HashMap r5 = new HashMap();
        if (r13 != null) goto L5;
    L11:
        Iterator r15 = r12.f4754a.iterator();
    L13:
        if (r15.hasNext() == false) goto L15;
        r5.put((String) r15.next(), new CheckRequestParamModel(null));
    L15:
        ReqType r16 = ReqType.NORMAL;
        ConcurrentHashMap r17 = new ConcurrentHashMap();
        if (r14.getTag() != null) goto L18;
    L20:
        boolean r10 = false;
    L21:
        List r11 = df.b.f16647h.a();
        Iterator r18 = r5.entrySet().iterator();
        String r19 = null;
    L23:
        if (r18.hasNext() == false) goto L50;
        Map.Entry r20 = (Map.Entry) r18.next();
        String r21 = (String) r20.getKey();
        if (r11 != null) goto L27;
    L29:
        CheckRequestParamModel r22 = (CheckRequestParamModel) r20.getValue();
        ArrayList r23 = new ArrayList();
        if (r22.getTargetChannels() == null) goto L37;
        Iterator<CheckRequestBodyModel.TargetChannel> r24 = r22.getTargetChannels().iterator();
    L33:
        if (r24.hasNext() == false) goto L37;
        CheckRequestBodyModel.TargetChannel r110 = r24.next();
        if (r23.contains(r110.channelName) == true) goto L33;
        r23.add(r110.channelName);
    L37:
        c r25 = b.f4736a;
        ArrayList r26 = new ArrayList();
        String r27 = r22.getGroup();
        if (TextUtils.isEmpty(r27) == true) goto L43;
        if ("default".equals(r27) == true) goto L43;
        r26.add(r27);
        r10 = true;
    L43:
        if (r23.isEmpty() == false) goto L48;
        if (r26.isEmpty() == false) goto L48;
        r19 = r21;
    L48:
        r17.put(r21, new DeploymentsData(r26, r23));
        goto L23
    L27:
        if (r11.contains(r21) == false) goto L29;
        r10 = true;
        goto L29
    L50:
        if (TextUtils.isEmpty(r19) == true) goto L55;
        IllegalArgumentException r111 = new IllegalArgumentException("request params can not be null or empty");
        if (r14.getListener() == null) goto L80;
        r14.getListener().c(r111);
        throw r111;
    L80:
        throw r111;
    L55:
        AppSettingsManager$IGeckoAppSettings r28 = b.f4736a.a();
        if (r10 == true) goto L64;
        if (r28 == null) goto L64;
        if (r28.isForbidRequest() == false) goto L64;
        IllegalArgumentException r112 = new IllegalArgumentException("no need to request");
        if (r14.getListener() == null) goto L81;
        r14.getListener().c(r112);
        throw r112;
    L81:
        throw r112;
    L64:
        RequestBodyUpdate r29 = new RequestBodyUpdate(r16);
        r29.setDeployments(r17);
        r29.initCustom(new ArrayList(r17.keySet()), null, r14);
        new com.bytedance.iesgurd.request.g(r29, com.bytedance.apm.util.a.a(r14, null, null)).e();
        return;
    L18:
        if (r14.getTag().equals(GeckoFetcher.GECKO_SDK_INVOKE_SYNC_TAG) == false) goto L20;
        r10 = true;
        goto L21
    L5:
        if (r13.isEmpty() == true) goto L11;
        Iterator r113 = r13.entrySet().iterator();
    L9:
        if (r113.hasNext() == false) goto L15;
        Map.Entry r114 = (Map.Entry) r113.next();
        r5.put(r114.getKey(), new CheckRequestParamModel(null, (List) r114.getValue()));
        goto L9
    }
}
