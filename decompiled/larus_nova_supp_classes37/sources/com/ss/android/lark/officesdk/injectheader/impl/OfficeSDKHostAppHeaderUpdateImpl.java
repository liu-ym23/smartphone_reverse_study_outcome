package com.ss.android.lark.officesdk.injectheader.impl;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.NetDecorator;
import com.bytedance.lark.pb.tool.v1.SetCustomParamsRequest;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.api.init.HostUriParamGroup;
import com.ss.android.lark.officesdk.container.OfficeSDKGlobalScope;
import com.ss.android.lark.sdk.SdkSender;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@OfficeSDKGlobalScope
public final class OfficeSDKHostAppHeaderUpdateImpl implements utb.a {

    public static final class a {
    }

    public static final class b<T> implements SdkSender.IParser {
        public static final b<T> a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final Object parse(byte[] r2) {
            Intrinsics.checkNotNullParameter(r2, "<unused var>");
            return null;
        }
    }

    static {
    }

    @Inject
    public OfficeSDKHostAppHeaderUpdateImpl() {
    }

    @Override // utb.a
    public final void G3(List<HostUriParamGroup> r8) {
        Intrinsics.checkNotNullParameter(r8, "params");
        Log.i("OfficeSDKHeaderUpdate", "updateHeader called: count=" + ((ArrayList) r8).size());
        Iterator<T> r0 = r8.iterator();
    L4:
        if (r0.hasNext() == false) goto L15;
        HostUriParamGroup r2 = (HostUriParamGroup) r0.next();
        Set<String> r3 = r2.getUris();
        if (r3 == null) goto L11;
        Iterator<T> r4 = r3.iterator();
    L9:
        if (r4.hasNext() == false) goto L11;
        Log.d("OfficeSDKHeaderUpdate", "HostApp header update uri: " + ((String) r4.next()));
    L11:
        Iterator<Map.Entry<String, String>> r5 = r2.getParams().entrySet().iterator();
    L13:
        if (r5.hasNext() == false) goto L4;
        Log.d("OfficeSDKHeaderUpdate", "HostApp header update param: " + r5.next());
        goto L13
    L15:
        final ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator<T> r9 = r8.iterator();
    L17:
        if (r9.hasNext() == false) goto L24;
        HostUriParamGroup r6 = (HostUriParamGroup) r9.next();
        Set<String> r7 = r6.getUris();
        if (r7 == null) goto L22;
        List r10 = CollectionsKt.toList(r7);
        if (r10 == null) goto L22;
    L23:
        r1.add(new NetDecorator.Builder().urls(r10).headers(r6.getParams()).build());
    L22:
        r10 = CollectionsKt.emptyList();
        goto L23
    L24:
        SdkSender.asynSendRequestNonWrap(Command.SET_CUSTOM_PARAMS, new SetCustomParamsRequest.Builder().net_decorators(r1), new OfficeSDKHostAppHeaderUpdateImpl$updateHeader$2(r1), b.a);
    }
}
