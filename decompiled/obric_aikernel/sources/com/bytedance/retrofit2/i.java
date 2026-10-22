package com.bytedance.retrofit2;

import com.bytedance.apm6.consumer.slardar.send.downgrade.DowngradeInfo;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    private static class a implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f2511a;

        a(String r10, String r11) {
            this.f2511a = r10;
        }

        @Override // com.bytedance.retrofit2.h
        public String a() {
            return this.f2511a;
        }
    }

    public static h a(String r10) {
        return new a(r10, DowngradeInfo.SubInfo.FIELD_DEFAULT_RATE);
    }
}
