package com.bytedance.retrofit2;

/* JADX INFO: loaded from: classes.dex */
public final class Endpoints {
    private static final String DEFAULT_NAME = "default";

    public static class FixedEndpoint implements Endpoint {
        private final String apiUrl;
        private final String name;

        public FixedEndpoint(String r8, String r10) {
            this.apiUrl = r8;
            this.name = r10;
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

    public static Endpoint newFixedEndpoint(String r8) {
        return new FixedEndpoint(r8, DEFAULT_NAME);
    }

    public static Endpoint newFixedEndpoint(String r8, String r10) {
        return new FixedEndpoint(r8, r10);
    }
}
