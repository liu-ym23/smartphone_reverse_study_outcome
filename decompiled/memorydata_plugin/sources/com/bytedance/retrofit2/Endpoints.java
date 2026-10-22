package com.bytedance.retrofit2;

/* JADX INFO: loaded from: classes2.dex */
public final class Endpoints {
    private static final String DEFAULT_NAME = "default";

    private static class FixedEndpoint implements Endpoint {
        private final String apiUrl;
        private final String name;

        FixedEndpoint(String r1, String r2) {
            this.apiUrl = r1;
            this.name = r2;
        }

        @Override // com.bytedance.retrofit2.Endpoint
        public String getName() {
            return this.name;
        }

        @Override // com.bytedance.retrofit2.Endpoint
        public String getUrl() {
            return this.apiUrl;
        }
    }

    private Endpoints() {
    }

    public static Endpoint newFixedEndpoint(String r2) {
        return new FixedEndpoint(r2, "default");
    }

    public static Endpoint newFixedEndpoint(String r1, String r2) {
        return new FixedEndpoint(r1, r2);
    }
}
