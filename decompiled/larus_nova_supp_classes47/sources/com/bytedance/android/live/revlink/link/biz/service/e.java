package com.bytedance.android.live.revlink.link.biz.service;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface e extends j {

    public static final class a {
        public static String a(e r3) {
            return r3.getTAG() + '.' + r3.getComponentName() + '.' + r3.hashCode();
        }
    }

    void attach();

    void detach();

    String getComponentName();

    @Override // com.bytedance.android.live.revlink.link.biz.service.j
    /* synthetic */ com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d getContext();

    String getTAG();
}
