package com.ttnet.org.chromium.net;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ExperimentalBidirectionalStream extends BidirectionalStream {

    public static abstract class Builder extends BidirectionalStream.Builder {
        public Builder() {
        }

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Builder
        public /* bridge */ /* synthetic */ BidirectionalStream.Builder addHeader(String r10, String r11) {
            return addHeader(r10, r11);
        }

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Builder
        public abstract Builder addHeader(String r10, String r11);

        public Builder addRequestAnnotation(Object r10) {
            return this;
        }

        public Builder bindToNetwork(long r10) {
            return this;
        }

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Builder
        public /* bridge */ /* synthetic */ BidirectionalStream build() {
            return build();
        }

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Builder
        public abstract ExperimentalBidirectionalStream build();

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Builder
        public /* bridge */ /* synthetic */ BidirectionalStream.Builder delayRequestHeadersUntilFirstFlush(boolean r10) {
            return delayRequestHeadersUntilFirstFlush(r10);
        }

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Builder
        public abstract Builder delayRequestHeadersUntilFirstFlush(boolean r10);

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Builder
        public /* bridge */ /* synthetic */ BidirectionalStream.Builder setHttpMethod(String r10) {
            return setHttpMethod(r10);
        }

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Builder
        public abstract Builder setHttpMethod(String r10);

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Builder
        public /* bridge */ /* synthetic */ BidirectionalStream.Builder setPriority(int r10) {
            return setPriority(r10);
        }

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Builder
        public abstract Builder setPriority(int r10);

        public Builder setTrafficStatsTag(int r10) {
            return this;
        }

        public Builder setTrafficStatsUid(int r10) {
            return this;
        }
    }

    public ExperimentalBidirectionalStream() {
    }
}
