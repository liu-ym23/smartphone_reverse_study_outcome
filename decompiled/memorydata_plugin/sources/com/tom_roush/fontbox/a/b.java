package com.tom_roush.fontbox.a;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f15886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f15887b;
    private float c;
    private float d;
    private float e;
    private float f;
    private float g;
    private float[] h;
    private float[] i;
    private float[] j;
    private float[] k;
    private String l;
    private com.tom_roush.fontbox.g.a m;
    private List<g> n;

    public b() {
        this.n = new ArrayList();
    }

    public int a() {
        return this.f15886a;
    }

    public void a(float r1) {
        this.c = r1;
    }

    public void a(int r1) {
        this.f15886a = r1;
    }

    public void a(g r1) {
        this.n.add(r1);
    }

    public void a(com.tom_roush.fontbox.g.a r1) {
        this.m = r1;
    }

    public void a(String r1) {
        this.l = r1;
    }

    public void a(float[] r1) {
        this.k = r1;
    }

    public String b() {
        return this.l;
    }

    public void b(float r1) {
        this.f = r1;
    }

    public void b(float[] r1) {
        this.h = r1;
    }

    public float c() {
        return this.f15887b;
    }

    public void c(float r1) {
        this.d = r1;
    }

    public void c(float[] r1) {
        this.i = r1;
    }

    public void d(float r1) {
        this.g = r1;
    }

    public void d(float[] r1) {
        this.j = r1;
    }

    public void e(float r1) {
        this.f15887b = r1;
    }

    public void f(float r1) {
        this.e = r1;
    }
}
