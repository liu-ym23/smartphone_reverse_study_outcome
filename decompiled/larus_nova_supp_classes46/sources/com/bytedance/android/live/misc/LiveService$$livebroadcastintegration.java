package com.bytedance.android.live.misc;

import com.bytedance.android.live.broadcast.BroadcastInitService;
import com.bytedance.android.live.broadcast.api.scope.global.IBroadcastInitService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class LiveService$$livebroadcastintegration {
    public LiveService$$livebroadcastintegration() {
    }

    public static void registerP0Service() {
        jc1.k.l(IBroadcastInitService.class, new BroadcastInitService());
    }

    public static void registerP1Service() {
        jc1.k.l(IBroadcastInitService.class, new BroadcastInitService());
    }

    public static void registerService() {
        jc1.k.l(IBroadcastInitService.class, new BroadcastInitService());
    }
}
