package com.larus.bmhome.resource.access;

import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d extends DelegatingResourceNode {
    public d() {
        super("local_detect", ResourcePhase.DETECT, CollectionsKt.listOf("preprocess"), true, ResourceNodeCompletionMode.DETACHED);
    }
}
