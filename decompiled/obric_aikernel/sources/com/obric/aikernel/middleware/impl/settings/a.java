package com.obric.aikernel.middleware.impl.settings;

import java.util.Set;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements s7.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @d6.c("model_center_keys")
    private final s7.a[] f4591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @d6.c("two_step_slm_model_keys")
    private final Set<String> f4592b;

    public a() {
        this.f4591a = new s7.a[]{new s7.a("slm_function_call", "function_call", 7), new s7.a("slm_intent_detection", "intent_detection", 5), new s7.a("slm_query_understanding", "query_understanding", 8), new s7.a("slm_reference_resolution", "reference_resolution", 6), new s7.a("slm_kg_extract_appentity_context", "slm_kg_extract_appentity_context", 12), new s7.a("vlm_build_memory", "vlm_build_memory", 14), new s7.a("slm_generic_response", "slm_generic_response", 17), new s7.a("bert_query_understanding_memory", "bert_query_understanding_memory", 20), new s7.a("intent_classification", "intent_classification", 23), new s7.a("slm_dialogue_rewriter", "dialogue_rewriter", 24), new s7.a("slm_function_call_25Q1", "function_call", 28), new s7.a("slm_intent_detection_25Q1", "intent_detection", 29), new s7.a("slm_reference_qa", "reference_qa", 10), new s7.a("slm_intent_detection_2", "intent_detection", 11), new s7.a("slm_function_call_2", "function_call_2", 18), new s7.a("slm_reference_qa_memory", "reference_qa_memory", 19)};
        this.f4592b = SetsKt.setOf("slm_summarize_cloud");
    }

    @Override // s7.b
    public Set<String> a() {
        return this.f4592b;
    }

    @Override // s7.b
    public s7.a[] b() {
        return this.f4591a;
    }

    public a c() {
        return new a();
    }
}
