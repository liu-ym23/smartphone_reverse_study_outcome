package com.ttnet.org.chromium.net;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ExperimentalBidirectionalStream extends BidirectionalStream {

    public static abstract class Builder extends BidirectionalStream.Builder {
        public Builder() {
        }

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Builder
        public /* bridge */ /* synthetic */ BidirectionalStream.Builder addHeader(String r8, String r10) {
            return addHeader(r8, r10);
        }

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Builder
        public abstract Builder addHeader(String r8, String r10);

        public Builder addRequestAnnotation(Object r8) {
            return this;
        }

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Builder
        public /* bridge */ /* synthetic */ BidirectionalStream build() {
            return build();
        }

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Builder
        public abstract ExperimentalBidirectionalStream build();

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Builder
        public /* bridge */ /* synthetic */ BidirectionalStream.Builder delayRequestHeadersUntilFirstFlush(boolean r8) {
            return delayRequestHeadersUntilFirstFlush(r8);
        }

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Builder
        public abstract Builder delayRequestHeadersUntilFirstFlush(boolean r8);

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Builder
        public /* bridge */ /* synthetic */ BidirectionalStream.Builder setHttpMethod(String r8) {
            return setHttpMethod(r8);
        }

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Builder
        public abstract Builder setHttpMethod(String r8);

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Builder
        public /* bridge */ /* synthetic */ BidirectionalStream.Builder setPriority(int r8) {
            return setPriority(r8);
        }

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Builder
        public abstract Builder setPriority(int r8);

        public Builder setTrafficStatsTag(int r8) {
            return this;
        }

        public Builder setTrafficStatsUid(int r8) {
            return this;
        }
    }

    public ExperimentalBidirectionalStream() {
    }
}
