package t1a;

import kotlin.reflect.KClass;
import m1a.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface b {
    <T extends c> T a(Class<T> r1);

    <T extends a> void b(Class<T> r1);

    <T extends a> void c(T r1, Class<? extends T> r2);

    <T extends a> T d(Class<T> r1);

    <T extends c> e<T> e(Class<T> r1);

    <T extends c> T f(Class<T> r1);

    <T extends c> T g(KClass<T> r1);

    <T extends a> T getAbility(Class<T> r1);

    <T extends f> void h(KClass<T> r1, c<?> r2);

    <T extends c> void i(T r1, KClass<? extends T> r2);

    <T extends f> c<T> j(KClass<T> r1);

    <T extends a> void k(T r1, KClass<? extends T> r2);

    <T extends a> void l(KClass<T> r1);

    <T extends c> void m(Class<T> r1);

    <T extends c> void n(T r1, Class<? extends T> r2);

    <T extends a> T o(KClass<T> r1);

    <T extends c> e<T> p(KClass<T> r1);
}
